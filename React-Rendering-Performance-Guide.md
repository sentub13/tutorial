# React Rendering & Performance Optimization Guide

## 🟡 4. Rendering & Performance Optimization (High Priority)

---

## 1. What is automatic batching in React 18?

**Automatic batching groups multiple state updates into a single re-render for better performance.**

* **React 18 improvement**: Batches all updates, not just event handlers
* **Better performance**: Fewer re-renders mean better performance
* **Automatic**: Works without any code changes
* **Opt-out available**: Use flushSync to force immediate updates

```jsx
import { useState } from 'react';
import { flushSync } from 'react-dom';

function AutomaticBatchingExample() {
  const [count, setCount] = useState(0);
  const [name, setName] = useState('John');
  const [loading, setLoading] = useState(false);
  
  console.log('Component rendered');
  
  // React 17: Multiple re-renders in timeouts/promises
  // React 18: Single re-render (automatic batching)
  const handleAsyncUpdate = () => {
    setTimeout(() => {
      setCount(c => c + 1);    // Batched
      setName('Jane');         // Batched
      setLoading(false);       // Batched
      // Only 1 re-render in React 18!
    }, 1000);
  };
  
  const handlePromiseUpdate = () => {
    fetch('/api/data').then(() => {
      setCount(c => c + 1);    // Batched
      setName('Bob');          // Batched
      setLoading(false);       // Batched
      // Only 1 re-render in React 18!
    });
  };
  
  // Event handlers were always batched (React 17 & 18)
  const handleSyncUpdate = () => {
    setCount(c => c + 1);      // Batched
    setName('Alice');          // Batched
    setLoading(true);          // Batched
    // Always 1 re-render
  };
  
  // Opt-out of batching when needed
  const handleImmediateUpdate = () => {
    flushSync(() => {
      setCount(c => c + 1);    // Immediate re-render
    });
    
    flushSync(() => {
      setName('Immediate');    // Another immediate re-render
    });
    // 2 separate re-renders
  };
  
  return (
    <div>
      <h1>Automatic Batching Demo</h1>
      <p>Count: {count}</p>
      <p>Name: {name}</p>
      <p>Loading: {loading ? 'Yes' : 'No'}</p>
      
      <button onClick={handleSyncUpdate}>Sync Update</button>
      <button onClick={handleAsyncUpdate}>Async Update</button>
      <button onClick={handlePromiseUpdate}>Promise Update</button>
      <button onClick={handleImmediateUpdate}>Immediate Update</button>
    </div>
  );
}

// Comparison: React 17 vs React 18
function BatchingComparison() {
  const [count, setCount] = useState(0);
  const [flag, setFlag] = useState(false);
  
  const handleClick = () => {
    // React 17: 2 re-renders in setTimeout
    // React 18: 1 re-render (batched)
    setTimeout(() => {
      setCount(c => c + 1);
      setFlag(f => !f);
    }, 100);
  };
  
  console.log('Rendered with count:', count, 'flag:', flag);
  
  return (
    <div>
      <p>Count: {count}, Flag: {flag.toString()}</p>
      <button onClick={handleClick}>Update in setTimeout</button>
    </div>
  );
}
```

---

## 2. What is Concurrent Rendering?

**Concurrent rendering allows React to pause, resume, and prioritize work for better user experience.**

* **Interruptible**: React can pause work and handle urgent updates
* **Priority-based**: High priority updates interrupt low priority ones
* **Better UX**: Keeps interface responsive during heavy computations
* **Opt-in**: Use concurrent features like useTransition, useDeferredValue

```jsx
import { useState, useTransition, useDeferredValue, Suspense } from 'react';

function ConcurrentRenderingExample() {
  const [query, setQuery] = useState('');
  const [items, setItems] = useState(generateItems(5000));
  const [isPending, startTransition] = useTransition();
  
  // Deferred value - lower priority
  const deferredQuery = useDeferredValue(query);
  
  // Filter items based on deferred query
  const filteredItems = items.filter(item =>
    item.name.toLowerCase().includes(deferredQuery.toLowerCase())
  );
  
  const handleSearch = (value) => {
    // High priority - immediate update
    setQuery(value);
    
    // Low priority - can be interrupted
    startTransition(() => {
      // Simulate expensive operation
      const newItems = generateItems(10000);
      setItems(newItems);
    });
  };
  
  return (
    <div>
      <h1>Concurrent Rendering Demo</h1>
      
      {/* Input stays responsive */}
      <input
        value={query}
        onChange={(e) => handleSearch(e.target.value)}
        placeholder="Search items..."
        style={{ fontSize: '16px', padding: '8px' }}
      />
      
      {isPending && <div>🔄 Updating items...</div>}
      
      {/* List updates with lower priority */}
      <div style={{ opacity: isPending ? 0.7 : 1 }}>
        <p>Found {filteredItems.length} items</p>
        <ItemList items={filteredItems.slice(0, 100)} />
      </div>
    </div>
  );
}

// Heavy component that benefits from concurrent rendering
function ItemList({ items }) {
  return (
    <ul>
      {items.map(item => (
        <li key={item.id}>
          {item.name} - {item.category}
        </li>
      ))}
    </ul>
  );
}

// Concurrent rendering with Suspense
function ConcurrentWithSuspense() {
  const [showHeavy, setShowHeavy] = useState(false);
  
  return (
    <div>
      <h2>Concurrent Rendering with Suspense</h2>
      <button onClick={() => setShowHeavy(!showHeavy)}>
        {showHeavy ? 'Hide' : 'Show'} Heavy Component
      </button>
      
      {showHeavy && (
        <Suspense fallback={<div>Loading heavy component...</div>}>
          <HeavyComponent />
        </Suspense>
      )}
    </div>
  );
}

// Simulate heavy component
function HeavyComponent() {
  const items = generateItems(1000);
  
  return (
    <div>
      <h3>Heavy Component</h3>
      {items.slice(0, 50).map(item => (
        <div key={item.id} style={{ padding: '4px', border: '1px solid #ccc' }}>
          {item.name} - {expensiveCalculation(item.id)}
        </div>
      ))}
    </div>
  );
}

function generateItems(count) {
  return Array.from({ length: count }, (_, i) => ({
    id: i,
    name: `Item ${i}`,
    category: `Category ${i % 5}`
  }));
}

function expensiveCalculation(n) {
  let result = 0;
  for (let i = 0; i < 1000; i++) {
    result += Math.sin(n + i);
  }
  return result.toFixed(2);
}
```

---

## 3. Difference between legacy and concurrent rendering

**Legacy rendering is synchronous and blocking, concurrent rendering is interruptible and prioritized.**

* **Legacy**: Synchronous, blocking, all-or-nothing updates
* **Concurrent**: Asynchronous, interruptible, priority-based updates
* **Performance**: Concurrent keeps UI responsive during heavy work
* **Backwards compatible**: Legacy mode still available

```jsx
import { useState, useTransition, useDeferredValue } from 'react';
import { createRoot } from 'react-dom/client';

// Legacy rendering behavior (React 17 style)
function LegacyBehaviorExample() {
  const [count, setCount] = useState(0);
  const [heavyList, setHeavyList] = useState([]);
  
  // In legacy mode, this blocks the UI
  const updateHeavyList = () => {
    const newList = [];
    
    // Expensive synchronous operation
    for (let i = 0; i < 10000; i++) {
      newList.push({
        id: i,
        value: Math.random(),
        computed: expensiveComputation(i)
      });
    }
    
    setHeavyList(newList);
    // UI is blocked until this completes
  };
  
  return (
    <div>
      <h2>Legacy Rendering (Blocking)</h2>
      
      {/* This button becomes unresponsive during heavy updates */}
      <button onClick={() => setCount(count + 1)}>
        Count: {count} (Try clicking during heavy update)
      </button>
      
      <button onClick={updateHeavyList}>
        Update Heavy List (Blocks UI)
      </button>
      
      <div>Items: {heavyList.length}</div>
    </div>
  );
}

// Concurrent rendering behavior (React 18)
function ConcurrentBehaviorExample() {
  const [count, setCount] = useState(0);
  const [heavyList, setHeavyList] = useState([]);
  const [isPending, startTransition] = useTransition();
  
  // In concurrent mode, this doesn't block the UI
  const updateHeavyList = () => {
    startTransition(() => {
      const newList = [];
      
      // Same expensive operation, but non-blocking
      for (let i = 0; i < 10000; i++) {
        newList.push({
          id: i,
          value: Math.random(),
          computed: expensiveComputation(i)
        });
      }
      
      setHeavyList(newList);
      // UI stays responsive!
    });
  };
  
  return (
    <div>
      <h2>Concurrent Rendering (Non-blocking)</h2>
      
      {/* This button stays responsive */}
      <button onClick={() => setCount(count + 1)}>
        Count: {count} (Always responsive!)
      </button>
      
      <button onClick={updateHeavyList} disabled={isPending}>
        {isPending ? 'Updating...' : 'Update Heavy List (Non-blocking)'}
      </button>
      
      <div>Items: {heavyList.length}</div>
    </div>
  );
}

// Comparison of rendering modes
function RenderingComparison() {
  const [mode, setMode] = useState('concurrent');
  const [input, setInput] = useState('');
  const [list, setList] = useState([]);
  const [isPending, startTransition] = useTransition();
  
  const deferredInput = useDeferredValue(input);
  
  const updateList = (value) => {
    const updateFn = () => {
      // Simulate expensive filtering
      const filtered = generateLargeList().filter(item =>
        item.toLowerCase().includes(value.toLowerCase())
      );
      setList(filtered);
    };
    
    if (mode === 'legacy') {
      // Legacy: Immediate, blocking update
      updateFn();
    } else {
      // Concurrent: Non-blocking update
      startTransition(updateFn);
    }
  };
  
  // Use deferred value in concurrent mode
  const displayValue = mode === 'concurrent' ? deferredInput : input;
  
  return (
    <div>
      <h2>Rendering Mode Comparison</h2>
      
      <div>
        <label>
          <input
            type="radio"
            checked={mode === 'legacy'}
            onChange={() => setMode('legacy')}
          />
          Legacy Mode (Blocking)
        </label>
        <label>
          <input
            type="radio"
            checked={mode === 'concurrent'}
            onChange={() => setMode('concurrent')}
          />
          Concurrent Mode (Non-blocking)
        </label>
      </div>
      
      <input
        value={input}
        onChange={(e) => {
          setInput(e.target.value);
          updateList(e.target.value);
        }}
        placeholder="Type to filter..."
      />
      
      {isPending && mode === 'concurrent' && <div>🔄 Filtering...</div>}
      
      <div>
        <p>Results for: "{displayValue}"</p>
        <p>Found: {list.length} items</p>
        <ul>
          {list.slice(0, 20).map((item, index) => (
            <li key={index}>{item}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

// How to enable concurrent rendering
function AppWithConcurrentMode() {
  return (
    <div>
      <LegacyBehaviorExample />
      <hr />
      <ConcurrentBehaviorExample />
      <hr />
      <RenderingComparison />
    </div>
  );
}

// Enable concurrent mode
const container = document.getElementById('root');
const root = createRoot(container); // Concurrent mode
root.render(<AppWithConcurrentMode />);

// Legacy mode (for comparison)
// ReactDOM.render(<App />, container); // Legacy mode

function expensiveComputation(n) {
  let result = 0;
  for (let i = 0; i < 100; i++) {
    result += Math.sin(n + i);
  }
  return result.toFixed(2);
}

function generateLargeList() {
  return Array.from({ length: 5000 }, (_, i) => `Item ${i} with some text`);
}
```

---

## 4. What is `startTransition` and `useTransition`?

**startTransition marks updates as non-urgent, useTransition provides pending state for transitions.**

* **Non-urgent updates**: Mark state updates as low priority
* **Interruptible**: Can be interrupted by urgent updates
* **Pending state**: useTransition provides loading state
* **Better UX**: Keeps interface responsive during heavy updates

```jsx
import { useState, useTransition, startTransition } from 'react';

function TransitionExample() {
  const [query, setQuery] = useState('');
  const [results, setResults] = useState([]);
  const [isPending, startTransition] = useTransition();
  
  const handleSearch = (value) => {
    // Urgent update - immediate
    setQuery(value);
    
    // Non-urgent update - can be interrupted
    startTransition(() => {
      // Expensive search operation
      const searchResults = performExpensiveSearch(value);
      setResults(searchResults);
    });
  };
  
  return (
    <div>
      <h2>useTransition Example</h2>
      
      {/* Input stays responsive */}
      <input
        value={query}
        onChange={(e) => handleSearch(e.target.value)}
        placeholder="Search..."
      />
      
      {/* Show pending state */}
      {isPending && <div>🔍 Searching...</div>}
      
      {/* Results update with lower priority */}
      <div style={{ opacity: isPending ? 0.5 : 1 }}>
        <p>Results for "{query}": {results.length} found</p>
        <ul>
          {results.slice(0, 50).map(result => (
            <li key={result.id}>{result.title}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

// Using startTransition without hook
function StartTransitionExample() {
  const [tab, setTab] = useState('home');
  const [content, setContent] = useState('Home content');
  
  const switchTab = (newTab) => {
    // Urgent update - immediate tab switch
    setTab(newTab);
    
    // Non-urgent update - content loading
    startTransition(() => {
      // Simulate expensive content loading
      const newContent = loadTabContent(newTab);
      setContent(newContent);
    });
  };
  
  return (
    <div>
      <h2>startTransition Example</h2>
      
      {/* Tabs switch immediately */}
      <div>
        {['home', 'about', 'contact'].map(tabName => (
          <button
            key={tabName}
            onClick={() => switchTab(tabName)}
            style={{
              background: tab === tabName ? '#007bff' : '#f8f9fa',
              color: tab === tabName ? 'white' : 'black'
            }}
          >
            {tabName.charAt(0).toUpperCase() + tabName.slice(1)}
          </button>
        ))}\n      </div>\n      \n      {/* Content loads with lower priority */}\n      <div>\n        <h3>Current Tab: {tab}</h3>\n        <p>{content}</p>\n      </div>\n    </div>\n  );\n}\n\n// Complex example with multiple transitions\nfunction MultipleTransitionsExample() {\n  const [filter, setFilter] = useState('all');\n  const [sort, setSort] = useState('name');\n  const [items, setItems] = useState(generateItems(1000));\n  const [isPending, startTransition] = useTransition();\n  \n  const updateView = (newFilter, newSort) => {\n    // Urgent updates - immediate UI feedback\n    setFilter(newFilter);\n    setSort(newSort);\n    \n    // Non-urgent update - expensive filtering and sorting\n    startTransition(() => {\n      let filtered = generateItems(5000);\n      \n      // Expensive filtering\n      if (newFilter !== 'all') {\n        filtered = filtered.filter(item => item.category === newFilter);\n      }\n      \n      // Expensive sorting\n      filtered.sort((a, b) => {\n        if (newSort === 'name') return a.name.localeCompare(b.name);\n        if (newSort === 'price') return a.price - b.price;\n        return a.id - b.id;\n      });\n      \n      setItems(filtered);\n    });\n  };\n  \n  return (\n    <div>\n      <h2>Multiple Transitions</h2>\n      \n      {/* Controls update immediately */}\n      <div>\n        <select \n          value={filter} \n          onChange={(e) => updateView(e.target.value, sort)}\n        >\n          <option value=\"all\">All Categories</option>\n          <option value=\"electronics\">Electronics</option>\n          <option value=\"clothing\">Clothing</option>\n          <option value=\"books\">Books</option>\n        </select>\n        \n        <select \n          value={sort} \n          onChange={(e) => updateView(filter, e.target.value)}\n        >\n          <option value=\"name\">Sort by Name</option>\n          <option value=\"price\">Sort by Price</option>\n          <option value=\"id\">Sort by ID</option>\n        </select>\n      </div>\n      \n      {isPending && <div>🔄 Updating results...</div>}\n      \n      {/* Results update with lower priority */}\n      <div style={{ opacity: isPending ? 0.7 : 1 }}>\n        <p>Filter: {filter}, Sort: {sort}</p>\n        <p>Items: {items.length}</p>\n        <ul>\n          {items.slice(0, 100).map(item => (\n            <li key={item.id}>\n              {item.name} - ${item.price} ({item.category})\n            </li>\n          ))}\n        </ul>\n      </div>\n    </div>\n  );\n}\n\nfunction performExpensiveSearch(query) {\n  const allItems = generateItems(10000);\n  \n  // Simulate expensive search\n  return allItems.filter(item => \n    item.name.toLowerCase().includes(query.toLowerCase()) ||\n    item.category.toLowerCase().includes(query.toLowerCase())\n  );\n}\n\nfunction loadTabContent(tab) {\n  // Simulate expensive content loading\n  const content = {\n    home: 'Welcome to the home page with lots of dynamic content...',\n    about: 'About us page with company information and history...',\n    contact: 'Contact information and form with validation...'\n  };\n  \n  // Simulate delay\n  for (let i = 0; i < 1000000; i++) {\n    Math.random();\n  }\n  \n  return content[tab] || 'Loading...';\n}\n\nfunction generateItems(count) {\n  const categories = ['electronics', 'clothing', 'books', 'home', 'sports'];\n  \n  return Array.from({ length: count }, (_, i) => ({\n    id: i,\n    name: `Item ${i}`,\n    price: Math.floor(Math.random() * 1000) + 10,\n    category: categories[i % categories.length]\n  }));\n}
```

---

## 5. Why does React Strict Mode double render in development?

**Strict Mode intentionally double-renders to help detect side effects and ensure components are pure.**

* **Side effect detection**: Helps find impure functions and side effects
* **Development only**: Only happens in development, not production
* **Pure components**: Ensures render functions don't cause side effects
* **Better debugging**: Makes bugs more obvious during development

```jsx
import React, { useState, useEffect } from 'react';

function StrictModeExample() {\n  const [count, setCount] = useState(0);\n  const [renderCount, setRenderCount] = useState(0);\n  \n  // This will run twice in Strict Mode\n  console.log('Component rendering, count:', count);\n  \n  // ❌ BAD - Side effect in render (Strict Mode will catch this)\n  // document.title = `Count: ${count}`; // Don't do this!\n  \n  // ✅ GOOD - Side effects in useEffect\n  useEffect(() => {\n    document.title = `Count: ${count}`;\n    console.log('useEffect running');\n  }, [count]);\n  \n  // This will also run twice in Strict Mode\n  const handleIncrement = () => {\n    console.log('Button clicked');\n    setCount(prev => prev + 1);\n  };\n  \n  // Track render count (will show double rendering)\n  React.useLayoutEffect(() => {\n    setRenderCount(prev => prev + 1);\n  });\n  \n  return (\n    <div>\n      <h2>Strict Mode Double Rendering</h2>\n      <p>Count: {count}</p>\n      <p>Render count: {renderCount}</p>\n      <button onClick={handleIncrement}>Increment</button>\n      <p>Check console to see double rendering</p>\n    </div>\n  );\n}\n\n// Example of component with side effects (bad)\nfunction ComponentWithSideEffects() {\n  const [items, setItems] = useState([]);\n  \n  // ❌ BAD - Side effect in render\n  // Strict Mode will make this obvious by running twice\n  if (items.length === 0) {\n    // This is a side effect in render - bad!\n    fetch('/api/items')\n      .then(res => res.json())\n      .then(setItems);\n  }\n  \n  console.log('ComponentWithSideEffects rendered');\n  \n  return (\n    <div>\n      <h3>Component with Side Effects (Bad)</h3>\n      <p>Items: {items.length}</p>\n    </div>\n  );\n}\n\n// Fixed version without side effects\nfunction ComponentWithoutSideEffects() {\n  const [items, setItems] = useState([]);\n  \n  // ✅ GOOD - Side effect in useEffect\n  useEffect(() => {\n    fetch('/api/items')\n      .then(res => res.json())\n      .then(setItems)\n      .catch(err => console.error('Failed to fetch items'));\n  }, []);\n  \n  console.log('ComponentWithoutSideEffects rendered');\n  \n  return (\n    <div>\n      <h3>Component without Side Effects (Good)</h3>\n      <p>Items: {items.length}</p>\n    </div>\n  );\n}\n\n// Example showing pure vs impure functions\nfunction PureVsImpureExample() {\n  const [count, setCount] = useState(0);\n  \n  // ❌ IMPURE - Modifies external state\n  let externalCounter = 0;\n  const impureFunction = () => {\n    externalCounter++; // Side effect!\n    return count * 2;\n  };\n  \n  // ✅ PURE - No side effects\n  const pureFunction = (value) => {\n    return value * 2;\n  };\n  \n  // Strict Mode will call these twice, making impure function obvious\n  const impureResult = impureFunction();\n  const pureResult = pureFunction(count);\n  \n  console.log('External counter:', externalCounter); // Will increment twice in Strict Mode\n  \n  return (\n    <div>\n      <h3>Pure vs Impure Functions</h3>\n      <p>Count: {count}</p>\n      <p>Pure result: {pureResult}</p>\n      <p>Impure result: {impureResult}</p>\n      <p>External counter: {externalCounter}</p>\n      <button onClick={() => setCount(count + 1)}>Increment</button>\n    </div>\n  );\n}\n\n// How to enable/disable Strict Mode\nfunction App() {\n  return (\n    <div>\n      <h1>React Strict Mode Examples</h1>\n      \n      {/* Components inside StrictMode will double render */}\n      <React.StrictMode>\n        <StrictModeExample />\n        <ComponentWithSideEffects />\n        <ComponentWithoutSideEffects />\n        <PureVsImpureExample />\n      </React.StrictMode>\n      \n      {/* Components outside StrictMode render normally */}\n      <div>\n        <h2>Outside Strict Mode (Normal Rendering)</h2>\n        <StrictModeExample />\n      </div>\n    </div>\n  );\n}\n\n// Benefits of Strict Mode double rendering:\n// 1. Detects side effects in render functions\n// 2. Ensures components are pure and predictable\n// 3. Helps identify unsafe lifecycle methods\n// 4. Makes bugs more obvious during development\n// 5. Prepares code for concurrent rendering
```

---

## 6. What is code splitting?

**Code splitting breaks your bundle into smaller chunks that load on-demand for better performance.**

* **Smaller bundles**: Load only what's needed initially
* **Lazy loading**: Load components/routes when needed
* **Better performance**: Faster initial page load
* **Dynamic imports**: Use import() for code splitting

```jsx
import React, { Suspense, lazy, useState } from 'react';\n\n// Lazy load components\nconst LazyDashboard = lazy(() => import('./Dashboard'));\nconst LazyProfile = lazy(() => import('./Profile'));\nconst LazySettings = lazy(() => import('./Settings'));\n\n// Route-based code splitting\nfunction CodeSplittingExample() {\n  const [currentView, setCurrentView] = useState('home');\n  \n  const renderView = () => {\n    switch (currentView) {\n      case 'dashboard':\n        return (\n          <Suspense fallback={<div>Loading Dashboard...</div>}>\n            <LazyDashboard />\n          </Suspense>\n        );\n      case 'profile':\n        return (\n          <Suspense fallback={<div>Loading Profile...</div>}>\n            <LazyProfile />\n          </Suspense>\n        );\n      case 'settings':\n        return (\n          <Suspense fallback={<div>Loading Settings...</div>}>\n            <LazySettings />\n          </Suspense>\n        );\n      default:\n        return <div>Welcome to Home Page</div>;\n    }\n  };\n  \n  return (\n    <div>\n      <h2>Code Splitting Example</h2>\n      \n      <nav>\n        <button onClick={() => setCurrentView('home')}>Home</button>\n        <button onClick={() => setCurrentView('dashboard')}>Dashboard</button>\n        <button onClick={() => setCurrentView('profile')}>Profile</button>\n        <button onClick={() => setCurrentView('settings')}>Settings</button>\n      </nav>\n      \n      <div style={{ padding: '20px', border: '1px solid #ccc' }}>\n        {renderView()}\n      </div>\n    </div>\n  );\n}\n\n// Dynamic import with loading states\nfunction DynamicImportExample() {\n  const [component, setComponent] = useState(null);\n  const [loading, setLoading] = useState(false);\n  const [error, setError] = useState(null);\n  \n  const loadComponent = async (componentName) => {\n    setLoading(true);\n    setError(null);\n    \n    try {\n      let ComponentModule;\n      \n      // Dynamic import based on component name\n      switch (componentName) {\n        case 'chart':\n          ComponentModule = await import('./ChartComponent');\n          break;\n        case 'table':\n          ComponentModule = await import('./TableComponent');\n          break;\n        case 'form':\n          ComponentModule = await import('./FormComponent');\n          break;\n        default:\n          throw new Error('Unknown component');\n      }\n      \n      setComponent(() => ComponentModule.default);\n    } catch (err) {\n      setError(err.message);\n    } finally {\n      setLoading(false);\n    }\n  };\n  \n  return (\n    <div>\n      <h3>Dynamic Import Example</h3>\n      \n      <div>\n        <button onClick={() => loadComponent('chart')}>Load Chart</button>\n        <button onClick={() => loadComponent('table')}>Load Table</button>\n        <button onClick={() => loadComponent('form')}>Load Form</button>\n      </div>\n      \n      {loading && <div>Loading component...</div>}\n      {error && <div>Error: {error}</div>}\n      {component && React.createElement(component)}\n    </div>\n  );\n}\n\n// Feature-based code splitting\nfunction FeatureBasedSplitting() {\n  const [features, setFeatures] = useState(new Set());\n  \n  const loadFeature = async (featureName) => {\n    if (features.has(featureName)) return;\n    \n    try {\n      // Load feature module dynamically\n      const featureModule = await import(`./features/${featureName}`);\n      \n      // Initialize feature\n      if (featureModule.init) {\n        featureModule.init();\n      }\n      \n      setFeatures(prev => new Set([...prev, featureName]));\n    } catch (error) {\n      console.error(`Failed to load feature: ${featureName}`, error);\n    }\n  };\n  \n  return (\n    <div>\n      <h3>Feature-based Code Splitting</h3>\n      \n      <div>\n        <button onClick={() => loadFeature('analytics')}>\n          Load Analytics {features.has('analytics') && '✓'}\n        </button>\n        <button onClick={() => loadFeature('reporting')}>\n          Load Reporting {features.has('reporting') && '✓'}\n        </button>\n        <button onClick={() => loadFeature('admin')}>\n          Load Admin {features.has('admin') && '✓'}\n        </button>\n      </div>\n      \n      <div>\n        <p>Loaded features: {Array.from(features).join(', ') || 'None'}</p>\n      </div>\n    </div>\n  );\n}\n\n// Library code splitting\nfunction LibraryCodeSplitting() {\n  const [chart, setChart] = useState(null);\n  const [data] = useState([1, 2, 3, 4, 5]);\n  \n  const loadChart = async () => {\n    // Only load heavy chart library when needed\n    const { Chart } = await import('chart.js/auto');\n    setChart(Chart);\n  };\n  \n  return (\n    <div>\n      <h3>Library Code Splitting</h3>\n      \n      {!chart ? (\n        <button onClick={loadChart}>Load Chart Library</button>\n      ) : (\n        <div>\n          <p>Chart library loaded!</p>\n          <canvas id=\"myChart\" width=\"400\" height=\"200\"></canvas>\n        </div>\n      )}\n    </div>\n  );\n}\n\n// Complete code splitting app\nfunction CodeSplittingApp() {\n  return (\n    <div>\n      <h1>Code Splitting Examples</h1>\n      \n      <CodeSplittingExample />\n      <hr />\n      <DynamicImportExample />\n      <hr />\n      <FeatureBasedSplitting />\n      <hr />\n      <LibraryCodeSplitting />\n    </div>\n  );\n}\n\n// Webpack bundle analysis\n// Run: npm run build -- --analyze\n// Or use webpack-bundle-analyzer\n\nexport default CodeSplittingApp;
```

---

## 7. What is lazy loading?

**Lazy loading defers loading of components until they're actually needed, improving initial load performance.**

* **On-demand loading**: Load components when needed, not upfront
* **Better performance**: Faster initial page load
* **React.lazy**: Built-in lazy loading for components
* **Suspense**: Handles loading states for lazy components

```jsx
import React, { Suspense, lazy, useState, useEffect } from 'react';\n\n// Basic lazy loading\nconst LazyComponent = lazy(() => import('./HeavyComponent'));\n\nfunction BasicLazyLoading() {\n  const [showComponent, setShowComponent] = useState(false);\n  \n  return (\n    <div>\n      <h2>Basic Lazy Loading</h2>\n      \n      <button onClick={() => setShowComponent(!showComponent)}>\n        {showComponent ? 'Hide' : 'Show'} Heavy Component\n      </button>\n      \n      {showComponent && (\n        <Suspense fallback={<div>Loading heavy component...</div>}>\n          <LazyComponent />\n        </Suspense>\n      )}\n    </div>\n  );\n}\n\n// Lazy loading with error boundary\nclass LazyErrorBoundary extends React.Component {\n  constructor(props) {\n    super(props);\n    this.state = { hasError: false };\n  }\n  \n  static getDerivedStateFromError(error) {\n    return { hasError: true };\n  }\n  \n  componentDidCatch(error, errorInfo) {\n    console.error('Lazy loading error:', error, errorInfo);\n  }\n  \n  render() {\n    if (this.state.hasError) {\n      return <div>Failed to load component. Please try again.</div>;\n    }\n    \n    return this.props.children;\n  }\n}\n\n// Lazy loading with retry\nfunction LazyWithRetry() {\n  const [Component, setComponent] = useState(null);\n  const [loading, setLoading] = useState(false);\n  const [error, setError] = useState(null);\n  \n  const loadComponent = async () => {\n    setLoading(true);\n    setError(null);\n    \n    try {\n      const module = await import('./HeavyComponent');\n      setComponent(() => module.default);\n    } catch (err) {\n      setError(err);\n    } finally {\n      setLoading(false);\n    }\n  };\n  \n  const retry = () => {\n    setError(null);\n    loadComponent();\n  };\n  \n  return (\n    <div>\n      <h3>Lazy Loading with Retry</h3>\n      \n      {!Component && !loading && !error && (\n        <button onClick={loadComponent}>Load Component</button>\n      )}\n      \n      {loading && <div>Loading...</div>}\n      \n      {error && (\n        <div>\n          <p>Failed to load component</p>\n          <button onClick={retry}>Retry</button>\n        </div>\n      )}\n      \n      {Component && <Component />}\n    </div>\n  );\n}\n\n// Intersection Observer lazy loading\nfunction IntersectionLazyLoading() {\n  const [isVisible, setIsVisible] = useState(false);\n  const [hasLoaded, setHasLoaded] = useState(false);\n  const ref = React.useRef();\n  \n  useEffect(() => {\n    const observer = new IntersectionObserver(\n      ([entry]) => {\n        if (entry.isIntersecting && !hasLoaded) {\n          setIsVisible(true);\n          setHasLoaded(true);\n        }\n      },\n      { threshold: 0.1 }\n    );\n    \n    if (ref.current) {\n      observer.observe(ref.current);\n    }\n    \n    return () => observer.disconnect();\n  }, [hasLoaded]);\n  \n  return (\n    <div>\n      <h3>Intersection Observer Lazy Loading</h3>\n      <div style={{ height: '1000px', background: '#f0f0f0' }}>\n        <p>Scroll down to load component...</p>\n      </div>\n      \n      <div ref={ref} style={{ minHeight: '200px', border: '2px dashed #ccc' }}>\n        {isVisible ? (\n          <Suspense fallback={<div>Loading when visible...</div>}>\n            <LazyComponent />\n          </Suspense>\n        ) : (\n          <div>Component will load when visible</div>\n        )}\n      </div>\n    </div>\n  );\n}\n\n// Image lazy loading\nfunction ImageLazyLoading() {\n  const [images, setImages] = useState([\n    { id: 1, src: 'https://picsum.photos/300/200?random=1', loaded: false },\n    { id: 2, src: 'https://picsum.photos/300/200?random=2', loaded: false },\n    { id: 3, src: 'https://picsum.photos/300/200?random=3', loaded: false },\n  ]);\n  \n  const LazyImage = ({ src, alt, id }) => {\n    const [isVisible, setIsVisible] = useState(false);\n    const [isLoaded, setIsLoaded] = useState(false);\n    const imgRef = React.useRef();\n    \n    useEffect(() => {\n      const observer = new IntersectionObserver(\n        ([entry]) => {\n          if (entry.isIntersecting) {\n            setIsVisible(true);\n            observer.disconnect();\n          }\n        },\n        { threshold: 0.1 }\n      );\n      \n      if (imgRef.current) {\n        observer.observe(imgRef.current);\n      }\n      \n      return () => observer.disconnect();\n    }, []);\n    \n    return (\n      <div ref={imgRef} style={{ minHeight: '200px', background: '#f5f5f5' }}>\n        {isVisible ? (\n          <img\n            src={src}\n            alt={alt}\n            onLoad={() => setIsLoaded(true)}\n            style={{\n              opacity: isLoaded ? 1 : 0,\n              transition: 'opacity 0.3s'\n            }}\n          />\n        ) : (\n          <div>Image will load when visible</div>\n        )}\n      </div>\n    );\n  };\n  \n  return (\n    <div>\n      <h3>Image Lazy Loading</h3>\n      <div style={{ height: '500px', overflow: 'auto' }}>\n        {images.map(image => (\n          <LazyImage\n            key={image.id}\n            id={image.id}\n            src={image.src}\n            alt={`Image ${image.id}`}\n          />\n        ))}\n      </div>\n    </div>\n  );\n}\n\n// Route-based lazy loading\nconst LazyHome = lazy(() => import('./pages/Home'));\nconst LazyAbout = lazy(() => import('./pages/About'));\nconst LazyContact = lazy(() => import('./pages/Contact'));\n\nfunction RouteLazyLoading() {\n  const [currentRoute, setCurrentRoute] = useState('home');\n  \n  const renderRoute = () => {\n    const routes = {\n      home: LazyHome,\n      about: LazyAbout,\n      contact: LazyContact\n    };\n    \n    const Component = routes[currentRoute];\n    \n    return (\n      <LazyErrorBoundary>\n        <Suspense fallback={<div>Loading page...</div>}>\n          <Component />\n        </Suspense>\n      </LazyErrorBoundary>\n    );\n  };\n  \n  return (\n    <div>\n      <h3>Route-based Lazy Loading</h3>\n      \n      <nav>\n        <button onClick={() => setCurrentRoute('home')}>Home</button>\n        <button onClick={() => setCurrentRoute('about')}>About</button>\n        <button onClick={() => setCurrentRoute('contact')}>Contact</button>\n      </nav>\n      \n      <div style={{ padding: '20px', border: '1px solid #ddd' }}>\n        {renderRoute()}\n      </div>\n    </div>\n  );\n}\n\n// Complete lazy loading app\nfunction LazyLoadingApp() {\n  return (\n    <div>\n      <h1>Lazy Loading Examples</h1>\n      \n      <BasicLazyLoading />\n      <hr />\n      <LazyWithRetry />\n      <hr />\n      <IntersectionLazyLoading />\n      <hr />\n      <ImageLazyLoading />\n      <hr />\n      <RouteLazyLoading />\n    </div>\n  );\n}\n\nexport default LazyLoadingApp;
```

---

## 8. How does `React.memo` work internally?

**React.memo is a higher-order component that memoizes the result and only re-renders when props change.**

* **Shallow comparison**: Compares props using Object.is()
* **Memoization**: Caches the rendered result
* **Performance optimization**: Prevents unnecessary re-renders
* **Custom comparison**: Can provide custom comparison function

```jsx
import React, { useState, memo, useCallback, useMemo } from 'react';\n\n// Basic React.memo usage\nconst BasicMemoComponent = memo(function BasicMemoComponent({ name, count }) {\n  console.log('BasicMemoComponent rendered');\n  \n  return (\n    <div>\n      <h3>Basic Memo Component</h3>\n      <p>Name: {name}</p>\n      <p>Count: {count}</p>\n    </div>\n  );\n});\n\n// React.memo with custom comparison\nconst CustomMemoComponent = memo(\n  function CustomMemoComponent({ user, settings }) {\n    console.log('CustomMemoComponent rendered');\n    \n    return (\n      <div>\n        <h3>Custom Memo Component</h3>\n        <p>User: {user.name}</p>\n        <p>Theme: {settings.theme}</p>\n      </div>\n    );\n  },\n  // Custom comparison function\n  (prevProps, nextProps) => {\n    // Return true if props are equal (skip re-render)\n    // Return false if props are different (re-render)\n    return (\n      prevProps.user.name === nextProps.user.name &&\n      prevProps.settings.theme === nextProps.settings.theme\n    );\n  }\n);\n\n// Component that shows memo behavior\nfunction MemoInternalExample() {\n  const [count, setCount] = useState(0);\n  const [name, setName] = useState('John');\n  const [unrelatedState, setUnrelatedState] = useState(0);\n  \n  const user = { name, id: 1 };\n  const settings = { theme: 'dark', lang: 'en' };\n  \n  console.log('Parent component rendered');\n  \n  return (\n    <div>\n      <h2>React.memo Internal Behavior</h2>\n      \n      <div>\n        <p>Count: {count}</p>\n        <p>Name: {name}</p>\n        <p>Unrelated: {unrelatedState}</p>\n        \n        <button onClick={() => setCount(count + 1)}>Update Count</button>\n        <button onClick={() => setName(name === 'John' ? 'Jane' : 'John')}>Toggle Name</button>\n        <button onClick={() => setUnrelatedState(unrelatedState + 1)}>Update Unrelated</button>\n      </div>\n      \n      {/* This will re-render when count or name changes */}\n      <BasicMemoComponent name={name} count={count} />\n      \n      {/* This will re-render based on custom comparison */}\n      <CustomMemoComponent user={user} settings={settings} />\n    </div>\n  );\n}\n\n// Demonstrating memo with object props\nfunction MemoWithObjectProps() {\n  const [count, setCount] = useState(0);\n  const [name, setName] = useState('John');\n  \n  // ❌ BAD - New object every render\n  const badUser = { name, id: 1 };\n  \n  // ✅ GOOD - Memoized object\n  const goodUser = useMemo(() => ({ name, id: 1 }), [name]);\n  \n  // ❌ BAD - New function every render\n  const badCallback = () => console.log('clicked');\n  \n  // ✅ GOOD - Memoized callback\n  const goodCallback = useCallback(() => console.log('clicked'), []);\n  \n  return (\n    <div>\n      <h3>Memo with Object Props</h3>\n      \n      <p>Count: {count}</p>\n      <button onClick={() => setCount(count + 1)}>Update Count</button>\n      \n      {/* Will re-render every time due to new object */}\n      <MemoChildWithBadProps user={badUser} onClick={badCallback} />\n      \n      {/* Will only re-render when user actually changes */}\n      <MemoChildWithGoodProps user={goodUser} onClick={goodCallback} />\n    </div>\n  );\n}\n\nconst MemoChildWithBadProps = memo(({ user, onClick }) => {\n  console.log('MemoChildWithBadProps rendered (always re-renders)');\n  \n  return (\n    <div style={{ border: '1px solid red', padding: '10px', margin: '5px' }}>\n      <p>Bad Props Child: {user.name}</p>\n      <button onClick={onClick}>Click</button>\n    </div>\n  );\n});\n\nconst MemoChildWithGoodProps = memo(({ user, onClick }) => {\n  console.log('MemoChildWithGoodProps rendered (only when needed)');\n  \n  return (\n    <div style={{ border: '1px solid green', padding: '10px', margin: '5px' }}>\n      <p>Good Props Child: {user.name}</p>\n      <button onClick={onClick}>Click</button>\n    </div>\n  );\n});\n\n// How React.memo works internally (simplified)\nfunction createMemoComponent(Component, compare) {\n  function MemoComponent(props) {\n    const ref = React.useRef();\n    \n    // First render or no previous props\n    if (!ref.current) {\n      ref.current = {\n        props,\n        result: React.createElement(Component, props)\n      };\n      return ref.current.result;\n    }\n    \n    // Compare props\n    const areEqual = compare \n      ? compare(ref.current.props, props)\n      : shallowEqual(ref.current.props, props);\n    \n    // If props are equal, return cached result\n    if (areEqual) {\n      return ref.current.result;\n    }\n    \n    // Props changed, re-render and cache\n    ref.current.props = props;\n    ref.current.result = React.createElement(Component, props);\n    return ref.current.result;\n  }\n  \n  return MemoComponent;\n}\n\n// Shallow comparison (simplified version of React's implementation)\nfunction shallowEqual(objA, objB) {\n  if (Object.is(objA, objB)) {\n    return true;\n  }\n  \n  if (typeof objA !== 'object' || objA === null ||\n      typeof objB !== 'object' || objB === null) {\n    return false;\n  }\n  \n  const keysA = Object.keys(objA);\n  const keysB = Object.keys(objB);\n  \n  if (keysA.length !== keysB.length) {\n    return false;\n  }\n  \n  for (let i = 0; i < keysA.length; i++) {\n    const key = keysA[i];\n    if (!Object.prototype.hasOwnProperty.call(objB, key) ||\n        !Object.is(objA[key], objB[key])) {\n      return false;\n    }\n  }\n  \n  return true;\n}\n\n// Performance comparison\nfunction PerformanceComparison() {\n  const [count, setCount] = useState(0);\n  const [renderCount, setRenderCount] = useState(0);\n  \n  React.useEffect(() => {\n    setRenderCount(prev => prev + 1);\n  });\n  \n  return (\n    <div>\n      <h3>Performance Comparison</h3>\n      <p>Parent renders: {renderCount}</p>\n      <p>Count: {count}</p>\n      \n      <button onClick={() => setCount(count + 1)}>Update Count</button>\n      \n      {/* Regular component - always re-renders */}\n      <RegularChild name=\"Regular\" />\n      \n      {/* Memoized component - only re-renders when props change */}\n      <MemoizedChild name=\"Memoized\" />\n    </div>\n  );\n}\n\nfunction RegularChild({ name }) {\n  console.log(`${name} child rendered`);\n  return <div>{name} Child Component</div>;\n}\n\nconst MemoizedChild = memo(function MemoizedChild({ name }) {\n  console.log(`${name} child rendered`);\n  return <div>{name} Child Component</div>;\n});\n\n// Complete React.memo demo\nfunction ReactMemoApp() {\n  return (\n    <div>\n      <h1>React.memo Internal Behavior</h1>\n      \n      <MemoInternalExample />\n      <hr />\n      <MemoWithObjectProps />\n      <hr />\n      <PerformanceComparison />\n    </div>\n  );\n}\n\nexport default ReactMemoApp;
```

---

## Quick Reference

```jsx
// React 18 Features
// 1. Automatic Batching - Groups multiple state updates
setTimeout(() => {
  setState1(value1); // Batched
  setState2(value2); // Batched
}, 1000); // Single re-render in React 18

// 2. Concurrent Rendering - Interruptible, priority-based
const [isPending, startTransition] = useTransition();
startTransition(() => {
  setExpensiveState(newValue); // Low priority, interruptible
});

// 3. Code Splitting - Load components on demand
const LazyComponent = lazy(() => import('./Component'));
<Suspense fallback={<Loading />}>
  <LazyComponent />
</Suspense>

// 4. React.memo - Prevent unnecessary re-renders
const MemoComponent = memo(({ prop1, prop2 }) => {
  return <div>{prop1} {prop2}</div>;
});

// 5. Performance Optimization Patterns
// - Use useMemo for expensive calculations
// - Use useCallback for stable function references
// - Use React.memo for component memoization
// - Use code splitting for large bundles
// - Use lazy loading for better initial load times

// Rendering Modes
// Legacy: ReactDOM.render(<App />, container)
// Concurrent: createRoot(container).render(<App />)
```

This comprehensive guide covers all essential React rendering and performance optimization concepts with practical examples and best practices!