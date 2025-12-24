# React Hooks Guide - Core + Advanced Concepts

## 🟢 2. React Hooks (Core + Advanced)

---

## 1. What are React Hooks and why were they introduced?

**Hooks are functions that let you use state and lifecycle features in functional components.**

• **Functional components**: No more class components needed
• **Reusable logic**: Share stateful logic between components
• **Simpler code**: Less boilerplate than class components
• **Better testing**: Easier to test and reason about
• **Gradual adoption**: Can use alongside existing class components

```jsx
// Before Hooks - Class Component
class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }
  
  render() {
    return (
      <div>
        <p>Count: {this.state.count}</p>
        <button onClick={() => this.setState({ count: this.state.count + 1 })}>
          +
        </button>
      </div>
    );
  }
}

// After Hooks - Functional Component
import { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);
  
  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
    </div>
  );
}
```

---

## 2. Rules of Hooks and why they exist

**Hooks must follow specific rules to work correctly with React's internal mechanisms.**

• **Top level only**: Never call hooks inside loops, conditions, or nested functions
• **React functions only**: Only call hooks from React function components or custom hooks
• **Same order**: Hooks must be called in the same order every time
• **Consistent calls**: React relies on call order to track hook state

```jsx
// ❌ WRONG - Breaking Rules of Hooks
function BadComponent({ condition }) {
  if (condition) {
    const [count, setCount] = useState(0); // Don't do this!
  }
  
  for (let i = 0; i < 3; i++) {
    useEffect(() => {}); // Don't do this!
  }
  
  return <div>Bad example</div>;
}

// ✅ CORRECT - Following Rules of Hooks
function GoodComponent({ condition }) {
  const [count, setCount] = useState(0);
  const [name, setName] = useState('');
  
  useEffect(() => {
    if (condition) {
      // Conditional logic inside hook is fine
      console.log('Condition is true');
    }
  }, [condition]);
  
  return (
    <div>
      <p>Count: {count}</p>
      <input value={name} onChange={(e) => setName(e.target.value)} />
    </div>
  );
}
```

---

## 3. What is `useState` and how does it work?

**useState adds state to functional components and returns current state and setter function.**

• **State management**: Manages component's local state
• **Returns array**: [currentState, setterFunction]
• **Triggers re-render**: Calling setter causes component to re-render
• **Initial value**: Can be a value or function

```jsx
import { useState } from 'react';

function StateExamples() {
  // Basic usage
  const [count, setCount] = useState(0);
  
  // With object
  const [user, setUser] = useState({ name: '', email: '' });
  
  // With array
  const [items, setItems] = useState(['apple', 'banana']);
  
  // Lazy initial state (function runs only once)
  const [expensiveValue, setExpensiveValue] = useState(() => {
    return computeExpensiveValue();
  });
  
  const updateUser = () => {
    setUser(prevUser => ({
      ...prevUser,
      name: 'John'
    }));
  };
  
  const addItem = () => {
    setItems(prevItems => [...prevItems, 'orange']);
  };
  
  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
      <button onClick={() => setCount(prev => prev + 1)}>Increment (functional)</button>
      
      <p>User: {user.name}</p>
      <button onClick={updateUser}>Update User</button>
      
      <ul>
        {items.map((item, index) => <li key={index}>{item}</li>)}
      </ul>
      <button onClick={addItem}>Add Item</button>
    </div>
  );
}

function computeExpensiveValue() {
  console.log('Computing expensive value...');
  return Math.random() * 1000;
}
```

---

## 4. What is `useEffect` and how does it work?

**useEffect handles side effects in functional components like API calls, subscriptions, and DOM manipulation.**

• **Side effects**: Data fetching, subscriptions, manual DOM changes
• **Lifecycle replacement**: Combines componentDidMount, componentDidUpdate, componentWillUnmount
• **Dependency array**: Controls when effect runs
• **Cleanup function**: Return function for cleanup (like componentWillUnmount)

```jsx
import { useState, useEffect } from 'react';

function EffectExamples() {
  const [count, setCount] = useState(0);
  const [user, setUser] = useState(null);
  
  // Runs after every render (no dependency array)
  useEffect(() => {
    document.title = `Count: ${count}`;
  });
  
  // Runs only once (empty dependency array)
  useEffect(() => {
    fetchUser().then(setUser);
  }, []);
  
  // Runs when count changes
  useEffect(() => {
    console.log('Count changed:', count);
  }, [count]);
  
  // Effect with cleanup
  useEffect(() => {
    const timer = setInterval(() => {
      setCount(prev => prev + 1);
    }, 1000);
    
    // Cleanup function
    return () => {
      clearInterval(timer);
    };
  }, []);
  
  return (
    <div>
      <p>Count: {count}</p>
      <p>User: {user?.name || 'Loading...'}</p>
      <button onClick={() => setCount(count + 1)}>Manual Increment</button>
    </div>
  );
}

async function fetchUser() {
  const response = await fetch('/api/user');
  return response.json();
}
```

---

## 5. Difference between `useState` and `useEffect`

**useState manages state, useEffect handles side effects - they serve different purposes.**

• **useState**: State management, triggers re-renders
• **useEffect**: Side effects, doesn't return state
• **When they run**: useState during render, useEffect after render
• **Purpose**: useState for data, useEffect for actions

```jsx
import { useState, useEffect } from 'react';

function ComparisonExample() {
  // useState - manages component state
  const [count, setCount] = useState(0);        // State management
  const [loading, setLoading] = useState(true); // State management
  const [data, setData] = useState(null);       // State management
  
  // useEffect - handles side effects
  useEffect(() => {
    // Side effect: API call
    fetchData()
      .then(result => {
        setData(result);    // Updates state
        setLoading(false);  // Updates state
      });
  }, []); // Runs once
  
  useEffect(() => {
    // Side effect: DOM manipulation
    document.title = `Count: ${count}`;
  }, [count]); // Runs when count changes
  
  useEffect(() => {
    // Side effect: subscription
    const subscription = subscribeToUpdates();
    
    return () => {
      // Side effect: cleanup
      subscription.unsubscribe();
    };
  }, []);
  
  if (loading) return <div>Loading...</div>;
  
  return (
    <div>
      <p>Count: {count}</p>
      <p>Data: {data?.message}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}

async function fetchData() {
  const response = await fetch('/api/data');
  return response.json();
}

function subscribeToUpdates() {
  return {
    unsubscribe: () => console.log('Unsubscribed')
  };
}
```

---

## 6. Difference between `useEffect`, `useLayoutEffect`, and `useInsertionEffect`

**Three effect hooks that run at different phases of the render cycle.**

• **useEffect**: Runs after DOM updates (asynchronous)
• **useLayoutEffect**: Runs before browser paint (synchronous)
• **useInsertionEffect**: Runs before DOM mutations (CSS-in-JS libraries)

```jsx
import { useState, useEffect, useLayoutEffect, useInsertionEffect } from 'react';

function EffectTimingExample() {
  const [count, setCount] = useState(0);
  
  // 3. useEffect - Runs AFTER browser paint (asynchronous)
  useEffect(() => {
    console.log('3. useEffect - after paint');
    // Good for: API calls, subscriptions, async operations
  }, [count]);
  
  // 2. useLayoutEffect - Runs BEFORE browser paint (synchronous)
  useLayoutEffect(() => {
    console.log('2. useLayoutEffect - before paint');
    // Good for: DOM measurements, synchronous DOM updates
    
    // Example: Measure element and update position
    const element = document.getElementById('measured-element');
    if (element) {
      const rect = element.getBoundingClientRect();
      console.log('Element width:', rect.width);
    }
  }, [count]);
  
  // 1. useInsertionEffect - Runs BEFORE DOM mutations (earliest)
  useInsertionEffect(() => {
    console.log('1. useInsertionEffect - before DOM mutations');
    // Good for: CSS-in-JS libraries, dynamic style injection
    
    // Example: Inject critical CSS
    const style = document.createElement('style');
    style.textContent = '.dynamic-style { color: red; }';
    document.head.appendChild(style);
    
    return () => {
      document.head.removeChild(style);
    };
  }, []);
  
  return (
    <div>
      <p id="measured-element">Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>
        Increment (check console for timing)
      </button>
    </div>
  );
}

// Practical example showing when to use each
function PracticalExample() {
  const [width, setWidth] = useState(0);
  const [data, setData] = useState(null);
  
  // useInsertionEffect - CSS injection
  useInsertionEffect(() => {
    const css = `
      .tooltip { 
        position: absolute; 
        background: black; 
        color: white; 
        padding: 4px; 
      }
    `;
    const style = document.createElement('style');
    style.textContent = css;
    document.head.appendChild(style);
    
    return () => document.head.removeChild(style);
  }, []);
  
  // useLayoutEffect - DOM measurements
  useLayoutEffect(() => {
    const element = document.getElementById('content');
    if (element) {
      setWidth(element.offsetWidth);
    }
  });
  
  // useEffect - Data fetching
  useEffect(() => {
    fetch('/api/data')
      .then(res => res.json())
      .then(setData);
  }, []);
  
  return (
    <div>
      <div id="content">Content width: {width}px</div>
      <div>Data: {data?.message || 'Loading...'}</div>
    </div>
  );
}
```

---

## 7. When should you avoid `useEffect`?

**Avoid useEffect for calculations, event handlers, and operations that don't need side effects.**

• **Calculations**: Use regular variables or useMemo instead
• **Event handlers**: Define functions directly, don't wrap in useEffect
• **Transforming data**: Do it during render, not in useEffect
• **Initializing state**: Use useState initializer or useMemo

```jsx
// ❌ WRONG - Don't use useEffect for calculations
function BadExample({ items }) {
  const [total, setTotal] = useState(0);
  
  useEffect(() => {
    setTotal(items.reduce((sum, item) => sum + item.price, 0));
  }, [items]); // Unnecessary effect!
  
  return <div>Total: ${total}</div>;
}

// ✅ CORRECT - Calculate during render
function GoodExample({ items }) {
  const total = items.reduce((sum, item) => sum + item.price, 0);
  
  return <div>Total: ${total}</div>;
}

// ❌ WRONG - Don't use useEffect for event handlers
function BadButton() {
  const [count, setCount] = useState(0);
  
  useEffect(() => {
    const handleClick = () => setCount(count + 1);
    // This creates problems with stale closures
  }, [count]);
  
  return <button>Bad approach</button>;
}

// ✅ CORRECT - Define event handlers directly
function GoodButton() {
  const [count, setCount] = useState(0);
  
  const handleClick = () => setCount(prev => prev + 1);
  
  return <button onClick={handleClick}>Count: {count}</button>;
}
```

---

## 8. How does the dependency array work internally?

**React compares each dependency with its previous value using Object.is() to decide if effect should run.**

• **Shallow comparison**: Uses Object.is() for each dependency
• **Array order**: Dependencies must be in same order every render
• **Reference equality**: Objects/arrays compared by reference, not content
• **Missing deps**: Can cause stale closures and bugs

```jsx
import { useState, useEffect } from 'react';

function DependencyExample() {
  const [count, setCount] = useState(0);
  const [user, setUser] = useState({ name: 'John' });
  
  // React internally does something like this:
  // if (count !== prevCount) { runEffect(); }
  useEffect(() => {
    console.log('Count changed:', count);
  }, [count]); // Object.is(count, prevCount)
  
  // ❌ WRONG - Object reference changes every render
  const config = { theme: 'dark' }; // New object every render!
  useEffect(() => {
    console.log('Config changed'); // Runs every render
  }, [config]);
  
  // ✅ CORRECT - Stable reference
  useEffect(() => {
    const config = { theme: 'dark' }; // Create inside effect
    console.log('Effect with stable config');
  }, []); // No dependencies
  
  // ✅ CORRECT - Primitive values work fine
  useEffect(() => {
    console.log('User name:', user.name);
  }, [user.name]); // Primitive string comparison
  
  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
      <button onClick={() => setUser({ name: 'Jane' })}>Change User</button>
    </div>
  );
}

// How React compares dependencies internally (simplified)
function compareDependencies(prevDeps, nextDeps) {
  if (prevDeps.length !== nextDeps.length) return false;
  
  for (let i = 0; i < prevDeps.length; i++) {
    if (!Object.is(prevDeps[i], nextDeps[i])) {
      return false; // Dependencies changed, run effect
    }
  }
  
  return true; // Dependencies same, skip effect
}
```

---

## 9. What is stale closure in hooks?

**Stale closure occurs when a function captures old values from previous renders.**

• **Closure problem**: Function remembers old values
• **Common with**: useEffect, event handlers, timers
• **Symptoms**: Using outdated state or props
• **Solution**: Use functional updates or useRef

```jsx
import { useState, useEffect, useRef } from 'react';

// ❌ PROBLEM - Stale closure
function StaleClosureExample() {
  const [count, setCount] = useState(0);
  
  useEffect(() => {
    const timer = setInterval(() => {
      console.log('Count:', count); // Always logs 0!
      setCount(count + 1);          // Always sets to 1!
    }, 1000);
    
    return () => clearInterval(timer);
  }, []); // Empty deps = closure captures initial count (0)
  
  return <div>Count: {count}</div>;
}

// ✅ SOLUTION 1 - Functional update
function FixedWithFunctionalUpdate() {
  const [count, setCount] = useState(0);
  
  useEffect(() => {
    const timer = setInterval(() => {
      setCount(prev => {
        console.log('Current count:', prev); // Always current!
        return prev + 1;
      });
    }, 1000);
    
    return () => clearInterval(timer);
  }, []); // No stale closure!
  
  return <div>Count: {count}</div>;
}

// ✅ SOLUTION 2 - useRef for mutable reference
function FixedWithRef() {
  const [count, setCount] = useState(0);
  const countRef = useRef(count);
  
  // Keep ref in sync
  useEffect(() => {
    countRef.current = count;
  });
  
  useEffect(() => {
    const timer = setInterval(() => {
      console.log('Count:', countRef.current); // Always current!
      setCount(prev => prev + 1);
    }, 1000);
    
    return () => clearInterval(timer);
  }, []);
  
  return <div>Count: {count}</div>;
}
```

---

## 10. How do you fix stale state issues?

**Use functional updates, useRef, or include dependencies to avoid stale state.**

• **Functional updates**: Use prev => prev + 1 instead of direct values
• **useRef**: Store mutable references that don't cause re-renders
• **Dependencies**: Include all used values in dependency array
• **useCallback**: Memoize functions that depend on state

```jsx
import { useState, useEffect, useRef, useCallback } from 'react';

function StaleStateFixes() {
  const [count, setCount] = useState(0);
  const [name, setName] = useState('John');
  
  // ✅ FIX 1 - Functional updates
  const incrementWithFunctional = () => {
    setCount(prev => prev + 1); // Always uses latest state
  };
  
  // ✅ FIX 2 - useRef for mutable values
  const latestCount = useRef(count);
  latestCount.current = count; // Always keep in sync
  
  const logCurrentCount = () => {
    console.log('Current count:', latestCount.current);
  };
  
  // ✅ FIX 3 - Include dependencies
  useEffect(() => {
    const timer = setTimeout(() => {
      console.log(`${name} has count: ${count}`);
    }, 1000);
    
    return () => clearTimeout(timer);
  }, [count, name]); // Include all used values
  
  // ✅ FIX 4 - useCallback with dependencies
  const handleClick = useCallback(() => {
    console.log(`Clicked with count: ${count}`);
    setCount(prev => prev + 1);
  }, [count]); // Recreate when count changes
  
  // ✅ FIX 5 - Custom hook for stable references
  const stableCallback = useStableCallback((value) => {
    console.log('Stable callback with:', value, count);
  });
  
  return (
    <div>
      <p>Count: {count}</p>
      <p>Name: {name}</p>
      <button onClick={incrementWithFunctional}>Increment</button>
      <button onClick={logCurrentCount}>Log Count</button>
      <button onClick={handleClick}>Handle Click</button>
      <button onClick={() => stableCallback('test')}>Stable</button>
      <input value={name} onChange={(e) => setName(e.target.value)} />
    </div>
  );
}

// Custom hook for stable callbacks
function useStableCallback(callback) {
  const callbackRef = useRef(callback);
  
  useEffect(() => {
    callbackRef.current = callback;
  });
  
  return useCallback((...args) => {
    return callbackRef.current(...args);
  }, []);
}
```

---

## 11. When would you use `useRef` instead of `useState`?

**Use useRef for mutable values that don't need to trigger re-renders.**

• **No re-renders**: Changing ref.current doesn't cause re-render
• **DOM access**: Direct access to DOM elements
• **Mutable values**: Store values that change but don't affect UI
• **Previous values**: Keep track of previous state/props

```jsx
import { useState, useRef, useEffect } from 'react';

function RefVsStateExample() {
  const [count, setCount] = useState(0);        // Triggers re-render
  const renderCount = useRef(0);                // No re-render
  const inputRef = useRef(null);                // DOM reference
  const previousCount = useRef(0);              // Previous value
  const timerRef = useRef(null);                // Mutable value
  
  // Track render count (doesn't trigger re-render)
  renderCount.current += 1;
  
  // Store previous count
  useEffect(() => {
    previousCount.current = count;
  });
  
  const startTimer = () => {
    if (timerRef.current) return; // Already running
    
    timerRef.current = setInterval(() => {
      setCount(prev => prev + 1);
    }, 1000);
  };
  
  const stopTimer = () => {
    if (timerRef.current) {
      clearInterval(timerRef.current);
      timerRef.current = null;
    }
  };
  
  const focusInput = () => {
    inputRef.current?.focus(); // DOM manipulation
  };
  
  return (
    <div>
      <p>Count: {count}</p>
      <p>Previous: {previousCount.current}</p>
      <p>Renders: {renderCount.current}</p>
      
      <input ref={inputRef} placeholder="Focus me" />
      
      <div>
        <button onClick={() => setCount(count + 1)}>+1 (re-render)</button>
        <button onClick={focusInput}>Focus Input</button>
        <button onClick={startTimer}>Start Timer</button>
        <button onClick={stopTimer}>Stop Timer</button>
      </div>
    </div>
  );
}

// When to use each:
function UsageGuide() {
  // useState - when you need re-renders
  const [visible, setVisible] = useState(true);     // UI state
  const [items, setItems] = useState([]);           // Data that affects UI
  
  // useRef - when you DON'T need re-renders
  const clickCount = useRef(0);                     // Counter (no UI update)
  const cache = useRef(new Map());                  // Cache (no UI update)
  const elementRef = useRef(null);                  // DOM reference
  const intervalRef = useRef(null);                 // Timer reference
  
  const handleClick = () => {
    clickCount.current += 1;  // No re-render
    console.log('Clicked:', clickCount.current);
  };
  
  return (
    <div ref={elementRef}>
      {visible && <p>Visible content</p>}
      <button onClick={handleClick}>Click (no re-render)</button>
      <button onClick={() => setVisible(!visible)}>Toggle (re-render)</button>
    </div>
  );
}
```

---

## 12. What is `useMemo` and when should you use it?

**useMemo memoizes expensive calculations and prevents unnecessary re-computations.**

• **Performance optimization**: Avoid expensive calculations on every render
• **Referential equality**: Keep same object reference between renders
• **Dependency-based**: Only recalculates when dependencies change
• **Don't overuse**: Only for expensive operations or referential equality

```jsx
import { useState, useMemo, useCallback } from 'react';

function MemoExample({ items, filter }) {
  const [count, setCount] = useState(0);
  
  // ✅ GOOD - Expensive calculation
  const expensiveValue = useMemo(() => {
    console.log('Computing expensive value...');
    return items
      .filter(item => item.category === filter)
      .reduce((sum, item) => sum + item.price * item.quantity, 0);
  }, [items, filter]); // Only recalculate when these change
  
  // ✅ GOOD - Referential equality for child components
  const sortedItems = useMemo(() => {
    return [...items].sort((a, b) => a.name.localeCompare(b.name));
  }, [items]);
  
  // ❌ BAD - Don't memo simple calculations
  const badExample = useMemo(() => {
    return count * 2; // Too simple, not worth memoizing
  }, [count]);
  
  // ✅ GOOD - Complex object that child components depend on
  const config = useMemo(() => ({
    theme: 'dark',
    settings: { showDetails: true },
    handlers: {
      onEdit: (id) => console.log('Edit:', id),
      onDelete: (id) => console.log('Delete:', id)
    }
  }), []); // Stable reference
  
  return (
    <div>
      <p>Count: {count}</p>
      <p>Total: ${expensiveValue}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
      
      <ItemList items={sortedItems} config={config} />
    </div>
  );
}

// Child component that benefits from memoization
const ItemList = React.memo(({ items, config }) => {
  console.log('ItemList rendered'); // Only when props actually change
  
  return (
    <ul>
      {items.map(item => (
        <li key={item.id}>
          {item.name} - ${item.price}
          <button onClick={() => config.handlers.onEdit(item.id)}>Edit</button>
        </li>
      ))}
    </ul>
  );
});

// When to use useMemo:
function UseMemoGuide() {
  const [search, setSearch] = useState('');
  const [data, setData] = useState([]);
  
  // ✅ USE - Expensive filtering/sorting
  const filteredData = useMemo(() => {
    return data
      .filter(item => item.name.toLowerCase().includes(search.toLowerCase()))
      .sort((a, b) => a.score - b.score);
  }, [data, search]);
  
  // ✅ USE - Complex object for child props
  const chartConfig = useMemo(() => ({
    type: 'bar',
    data: filteredData,
    options: { responsive: true }
  }), [filteredData]);
  
  // ❌ DON'T USE - Simple operations
  const simpleCalc = search.length > 0 ? 'searching' : 'idle'; // Just calculate directly
  
  return (
    <div>
      <input value={search} onChange={(e) => setSearch(e.target.value)} />
      <p>Status: {simpleCalc}</p>
      <Chart config={chartConfig} />
    </div>
  );
}

const Chart = React.memo(({ config }) => {
  // This won't re-render unless config reference changes
  return <div>Chart with {config.data.length} items</div>;
});
```

---

## 13. What is `useCallback` and when should you use it?

**useCallback memoizes functions to prevent unnecessary re-creations and child re-renders.**

• **Function memoization**: Returns same function reference between renders
• **Child optimization**: Prevents unnecessary re-renders of child components
• **Dependency-based**: Only recreates when dependencies change
• **Event handlers**: Especially useful for event handlers passed to children

```jsx
import { useState, useCallback, memo } from 'react';

function CallbackExample() {
  const [count, setCount] = useState(0);
  const [name, setName] = useState('John');
  
  // ❌ BAD - New function every render
  const badHandler = () => {
    console.log('Clicked with count:', count);
  };
  
  // ✅ GOOD - Memoized function
  const goodHandler = useCallback(() => {
    console.log('Clicked with count:', count);
  }, [count]); // Only recreate when count changes
  
  // ✅ GOOD - Stable function (no dependencies)
  const incrementCount = useCallback(() => {
    setCount(prev => prev + 1);
  }, []); // Never recreates
  
  const updateName = useCallback((newName) => {
    setName(newName);
  }, []);
  
  return (
    <div>
      <p>Count: {count}, Name: {name}</p>
      
      {/* Child will re-render every time with badHandler */}
      <ExpensiveChild onClick={badHandler} label="Bad" />
      
      {/* Child only re-renders when goodHandler changes */}
      <ExpensiveChild onClick={goodHandler} label="Good" />
      
      {/* Child never re-renders (stable function) */}
      <Button onClick={incrementCount}>Increment</Button>
      <NameInput onUpdate={updateName} />
    </div>
  );
}

// Memoized child component
const ExpensiveChild = memo(({ onClick, label }) => {
  console.log(`${label} child rendered`);
  return <button onClick={onClick}>{label} Button</button>;
});

const Button = memo(({ onClick, children }) => {
  console.log('Button rendered');
  return <button onClick={onClick}>{children}</button>;
});

const NameInput = memo(({ onUpdate }) => {
  return (
    <input 
      onChange={(e) => onUpdate(e.target.value)}
      placeholder="Enter name"
    />
  );
});
```

---

## 14. Difference between `useMemo` and `useCallback`

**useMemo memoizes values, useCallback memoizes functions - both prevent unnecessary recalculations.**

• **useMemo**: Returns memoized value (result of computation)
• **useCallback**: Returns memoized function (the function itself)
• **Purpose**: useMemo for expensive calculations, useCallback for stable function references
• **Equivalent**: useCallback(fn, deps) === useMemo(() => fn, deps)

```jsx
import { useState, useMemo, useCallback } from 'react';

function MemoVsCallbackExample({ items }) {
  const [count, setCount] = useState(0);
  const [filter, setFilter] = useState('');
  
  // useMemo - memoizes the RESULT (value)
  const expensiveValue = useMemo(() => {
    console.log('Computing expensive value...');
    return items
      .filter(item => item.name.includes(filter))
      .reduce((sum, item) => sum + item.price, 0);
  }, [items, filter]); // Returns: number
  
  // useCallback - memoizes the FUNCTION itself
  const handleFilter = useCallback((newFilter) => {
    console.log('Filter function called');
    setFilter(newFilter);
  }, []); // Returns: function
  
  // They're equivalent in this case:
  const memoizedFunction = useMemo(() => {
    return (newFilter) => setFilter(newFilter);
  }, []); // Same as useCallback above
  
  // Practical example showing the difference
  const processedData = useMemo(() => {
    // Heavy computation - return the VALUE
    return items.map(item => ({
      ...item,
      displayName: item.name.toUpperCase(),
      isExpensive: item.price > 100
    }));
  }, [items]);
  
  const handleItemClick = useCallback((itemId) => {
    // Event handler - return the FUNCTION
    console.log('Item clicked:', itemId);
    // Some logic here
  }, []);
  
  return (
    <div>
      <p>Count: {count}</p>
      <p>Total: ${expensiveValue}</p>
      
      <input 
        onChange={(e) => handleFilter(e.target.value)}
        placeholder="Filter items"
      />
      
      <ItemList 
        items={processedData}     // Memoized value
        onItemClick={handleItemClick}  // Memoized function
      />
      
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}

// Summary of differences:
function ComparisonSummary() {
  const [data, setData] = useState([]);
  
  // useMemo: "Remember this calculated VALUE"
  const sortedData = useMemo(() => {
    return [...data].sort((a, b) => a.name.localeCompare(b.name));
  }, [data]); // Type: Array
  
  // useCallback: "Remember this FUNCTION"
  const handleSort = useCallback((sortKey) => {
    setData(prev => [...prev].sort((a, b) => a[sortKey].localeCompare(b[sortKey])));
  }, []); // Type: Function
  
  return { sortedData, handleSort };
}
```

---

## 15. What is `useReducer` and how is it different from `useState`?

**useReducer manages complex state with predictable updates through reducer functions.**

• **Complex state**: Better for objects with multiple related values
• **Predictable updates**: All state changes go through reducer function
• **Action-based**: Update state by dispatching actions
• **Redux-like**: Similar pattern to Redux but local to component

```jsx
import { useReducer, useState } from 'react';

// Reducer function - pure function that returns new state
function counterReducer(state, action) {
  switch (action.type) {
    case 'increment':
      return { count: state.count + 1 };
    case 'decrement':
      return { count: state.count - 1 };
    case 'reset':
      return { count: 0 };
    case 'set':
      return { count: action.payload };
    default:
      throw new Error(`Unknown action: ${action.type}`);
  }
}

function ReducerExample() {
  // useReducer: [state, dispatch]
  const [state, dispatch] = useReducer(counterReducer, { count: 0 });
  
  return (
    <div>
      <p>Count: {state.count}</p>
      <button onClick={() => dispatch({ type: 'increment' })}>+</button>
      <button onClick={() => dispatch({ type: 'decrement' })}>-</button>
      <button onClick={() => dispatch({ type: 'reset' })}>Reset</button>
      <button onClick={() => dispatch({ type: 'set', payload: 10 })}>Set to 10</button>
    </div>
  );
}

// Complex state example - better with useReducer
function FormExample() {
  // Complex state with multiple related values
  const initialState = {
    name: '',
    email: '',
    errors: {},
    isSubmitting: false
  };
  
  function formReducer(state, action) {
    switch (action.type) {
      case 'SET_FIELD':
        return {
          ...state,
          [action.field]: action.value,
          errors: { ...state.errors, [action.field]: null }
        };
      case 'SET_ERROR':
        return {
          ...state,
          errors: { ...state.errors, [action.field]: action.error }
        };
      case 'SET_SUBMITTING':
        return { ...state, isSubmitting: action.value };
      case 'RESET':
        return initialState;
      default:
        return state;
    }
  }
  
  const [state, dispatch] = useReducer(formReducer, initialState);
  
  const handleSubmit = async (e) => {
    e.preventDefault();
    dispatch({ type: 'SET_SUBMITTING', value: true });
    
    try {
      await submitForm(state);
      dispatch({ type: 'RESET' });
    } catch (error) {
      dispatch({ type: 'SET_ERROR', field: 'general', error: error.message });
    } finally {
      dispatch({ type: 'SET_SUBMITTING', value: false });
    }
  };
  
  return (
    <form onSubmit={handleSubmit}>
      <input
        value={state.name}
        onChange={(e) => dispatch({ type: 'SET_FIELD', field: 'name', value: e.target.value })}
        placeholder="Name"
      />
      {state.errors.name && <span>{state.errors.name}</span>}
      
      <input
        value={state.email}
        onChange={(e) => dispatch({ type: 'SET_FIELD', field: 'email', value: e.target.value })}
        placeholder="Email"
      />
      {state.errors.email && <span>{state.errors.email}</span>}
      
      <button disabled={state.isSubmitting}>Submit</button>
      {state.errors.general && <div>{state.errors.general}</div>}
    </form>
  );
}

// When to use each:
function ComparisonExample() {
  // useState - simple, independent state
  const [count, setCount] = useState(0);
  const [name, setName] = useState('');
  
  // useReducer - complex, related state
  const [todoState, dispatch] = useReducer(todoReducer, {
    todos: [],
    filter: 'all',
    isLoading: false
  });
  
  return (
    <div>
      {/* Simple state updates */}
      <button onClick={() => setCount(count + 1)}>Count: {count}</button>
      
      {/* Complex state updates */}
      <button onClick={() => dispatch({ type: 'ADD_TODO', text: 'New todo' })}>
        Add Todo
      </button>
    </div>
  );
}

function todoReducer(state, action) {
  switch (action.type) {
    case 'ADD_TODO':
      return {
        ...state,
        todos: [...state.todos, { id: Date.now(), text: action.text, done: false }]
      };
    case 'TOGGLE_TODO':
      return {
        ...state,
        todos: state.todos.map(todo =>
          todo.id === action.id ? { ...todo, done: !todo.done } : todo
        )
      };
    case 'SET_FILTER':
      return { ...state, filter: action.filter };
    default:
      return state;
  }
}

async function submitForm(data) {
  // Simulate API call
  await new Promise(resolve => setTimeout(resolve, 1000));
}
```

---

## 16. Can hooks replace all lifecycle methods? (mapping)

**Yes, hooks can replace all class lifecycle methods with useEffect and other hooks.**

• **useEffect**: Covers most lifecycle methods
• **useLayoutEffect**: For synchronous effects
• **Custom hooks**: Can encapsulate complex lifecycle logic
• **Cleaner code**: More predictable than class lifecycles

```jsx
import { useState, useEffect, useLayoutEffect, useRef } from 'react';

// Class component lifecycle mapping
class ClassComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }
  
  componentDidMount() {
    console.log('Mounted');
    document.title = 'Component mounted';
  }
  
  componentDidUpdate(prevProps, prevState) {
    if (prevState.count !== this.state.count) {
      console.log('Count updated');
    }
  }
  
  componentWillUnmount() {
    console.log('Unmounting');
  }
  
  render() {
    return <div>Count: {this.state.count}</div>;
  }
}

// Hooks equivalent
function HooksComponent() {
  const [count, setCount] = useState(0);
  const prevCount = useRef();
  
  // componentDidMount
  useEffect(() => {
    console.log('Mounted');
    document.title = 'Component mounted';
  }, []); // Empty deps = mount only
  
  // componentDidUpdate (for count)
  useEffect(() => {
    if (prevCount.current !== undefined) {
      console.log('Count updated');
    }
    prevCount.current = count;
  }, [count]); // Runs when count changes
  
  // componentWillUnmount
  useEffect(() => {
    return () => {
      console.log('Unmounting');
    };
  }, []); // Cleanup function
  
  return <div>Count: {count}</div>;
}

// Complete lifecycle mapping
function LifecycleMappingExample({ userId }) {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const mountedRef = useRef(true);
  
  // constructor equivalent
  const initialState = useState(() => {
    console.log('Constructor equivalent - runs once');
    return { user: null, loading: true };
  });
  
  // componentDidMount + componentDidUpdate
  useEffect(() => {
    console.log('Effect runs on mount and when userId changes');
    
    const fetchUser = async () => {
      setLoading(true);
      try {
        const userData = await fetch(`/api/users/${userId}`);
        if (mountedRef.current) {
          setUser(userData);
        }
      } finally {
        if (mountedRef.current) {
          setLoading(false);
        }
      }
    };
    
    fetchUser();
  }, [userId]); // Dependency array controls when it runs
  
  // componentWillUnmount
  useEffect(() => {
    return () => {
      console.log('Cleanup - componentWillUnmount equivalent');
      mountedRef.current = false;
    };
  }, []);
  
  // getSnapshotBeforeUpdate equivalent (rare)
  useLayoutEffect(() => {
    const snapshot = document.documentElement.scrollTop;
    return () => {
      // Use snapshot if needed
    };
  });
  
  if (loading) return <div>Loading...</div>;
  return <div>User: {user?.name}</div>;
}

// Advanced lifecycle patterns
function AdvancedLifecycleHooks() {
  const [data, setData] = useState(null);
  
  // Multiple effects for separation of concerns
  useEffect(() => {
    // Data fetching logic
    fetchData().then(setData);
  }, []);
  
  useEffect(() => {
    // Analytics tracking
    trackPageView();
  }, []);
  
  useEffect(() => {
    // Event listeners
    const handleResize = () => console.log('Resized');
    window.addEventListener('resize', handleResize);
    
    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []);
  
  return <div>Advanced component</div>;
}

async function fetchData() {
  const response = await fetch('/api/data');
  return response.json();
}

function trackPageView() {
  console.log('Page viewed');
}
```

---

## 17. How do you create custom hooks?

**Custom hooks are functions that start with 'use' and can call other hooks.**

• **Reusable logic**: Extract and share stateful logic between components
• **Naming convention**: Must start with 'use'
• **Composition**: Can use other hooks inside
• **Return anything**: Can return values, functions, or objects

```jsx
import { useState, useEffect, useCallback } from 'react';

// Simple custom hook
function useCounter(initialValue = 0) {
  const [count, setCount] = useState(initialValue);
  
  const increment = useCallback(() => setCount(prev => prev + 1), []);
  const decrement = useCallback(() => setCount(prev => prev - 1), []);
  const reset = useCallback(() => setCount(initialValue), [initialValue]);
  
  return { count, increment, decrement, reset };
}

// Data fetching hook
function useFetch(url) {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  
  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        setError(null);
        const response = await fetch(url);
        const result = await response.json();
        setData(result);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };
    
    fetchData();
  }, [url]);
  
  return { data, loading, error };
}

// Local storage hook
function useLocalStorage(key, initialValue) {
  const [storedValue, setStoredValue] = useState(() => {
    try {
      const item = window.localStorage.getItem(key);
      return item ? JSON.parse(item) : initialValue;
    } catch (error) {
      return initialValue;
    }
  });
  
  const setValue = useCallback((value) => {
    try {
      setStoredValue(value);
      window.localStorage.setItem(key, JSON.stringify(value));
    } catch (error) {
      console.error('Error saving to localStorage:', error);
    }
  }, [key]);
  
  return [storedValue, setValue];
}

// Using custom hooks
function ComponentUsingCustomHooks() {
  const { count, increment, decrement, reset } = useCounter(10);
  const { data, loading, error } = useFetch('/api/users');
  const [name, setName] = useLocalStorage('userName', '');
  
  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
  
  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={increment}>+</button>
      <button onClick={decrement}>-</button>
      <button onClick={reset}>Reset</button>
      
      <p>Users: {data?.length}</p>
      
      <input 
        value={name} 
        onChange={(e) => setName(e.target.value)}
        placeholder="Your name"
      />
      <p>Saved name: {name}</p>
    </div>
  );
}

// Advanced custom hook with multiple features
function useApi(baseUrl) {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  
  const request = useCallback(async (endpoint, options = {}) => {
    setLoading(true);
    setError(null);
    
    try {
      const response = await fetch(`${baseUrl}${endpoint}`, {
        headers: { 'Content-Type': 'application/json' },
        ...options
      });
      
      if (!response.ok) throw new Error('Request failed');
      return await response.json();
    } catch (err) {
      setError(err.message);
      throw err;
    } finally {
      setLoading(false);
    }
  }, [baseUrl]);
  
  const get = useCallback((endpoint) => request(endpoint), [request]);
  const post = useCallback((endpoint, data) => 
    request(endpoint, { method: 'POST', body: JSON.stringify(data) }), [request]);
  
  return { request, get, post, loading, error };
}
```

---

## 18. How do you share logic without HOCs?

**Use custom hooks to share stateful logic between components without wrapper components.**

• **Custom hooks**: Extract logic into reusable functions
• **Composition**: Combine multiple hooks for complex logic
• **No wrapper hell**: Avoid nested HOC components
• **Better testing**: Easier to test isolated logic

```jsx
import { useState, useEffect, useCallback } from 'react';

// OLD WAY - Higher Order Component (HOC)
function withAuth(WrappedComponent) {
  return function AuthenticatedComponent(props) {
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);
    
    useEffect(() => {
      checkAuth().then(user => {
        setUser(user);
        setLoading(false);
      });
    }, []);
    
    if (loading) return <div>Loading...</div>;
    if (!user) return <div>Please login</div>;
    
    return <WrappedComponent {...props} user={user} />;
  };
}

// Usage with HOC (creates wrapper components)
const AuthenticatedProfile = withAuth(Profile);
const AuthenticatedDashboard = withAuth(Dashboard);

// NEW WAY - Custom Hook
function useAuth() {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  
  useEffect(() => {
    checkAuth()
      .then(setUser)
      .catch(setError)
      .finally(() => setLoading(false));
  }, []);
  
  const login = useCallback(async (credentials) => {
    setLoading(true);
    try {
      const user = await authenticate(credentials);
      setUser(user);
      return user;
    } catch (err) {
      setError(err.message);
      throw err;
    } finally {
      setLoading(false);
    }
  }, []);
  
  const logout = useCallback(() => {
    setUser(null);
    localStorage.removeItem('token');
  }, []);
  
  return { user, loading, error, login, logout };
}

// Usage with custom hook (no wrapper components)
function Profile() {
  const { user, loading, error, logout } = useAuth();
  
  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
  if (!user) return <div>Please login</div>;
  
  return (
    <div>
      <h1>Profile: {user.name}</h1>
      <button onClick={logout}>Logout</button>
    </div>
  );
}

function Dashboard() {
  const { user, loading } = useAuth();
  
  if (loading) return <div>Loading...</div>;
  if (!user) return <div>Please login</div>;
  
  return <div>Dashboard for {user.name}</div>;
}

// Complex logic sharing with multiple hooks
function useFormWithValidation(initialValues, validationRules) {
  const [values, setValues] = useState(initialValues);
  const [errors, setErrors] = useState({});
  const [touched, setTouched] = useState({});
  
  const validate = useCallback((fieldName, value) => {
    const rule = validationRules[fieldName];
    if (!rule) return null;
    
    if (rule.required && !value) {
      return 'This field is required';
    }
    if (rule.minLength && value.length < rule.minLength) {
      return `Minimum length is ${rule.minLength}`;
    }
    return null;
  }, [validationRules]);
  
  const setValue = useCallback((fieldName, value) => {
    setValues(prev => ({ ...prev, [fieldName]: value }));
    
    const error = validate(fieldName, value);
    setErrors(prev => ({ ...prev, [fieldName]: error }));
  }, [validate]);
  
  const setTouched = useCallback((fieldName) => {
    setTouched(prev => ({ ...prev, [fieldName]: true }));
  }, []);
  
  const isValid = Object.values(errors).every(error => !error);
  
  return {
    values,
    errors,
    touched,
    setValue,
    setTouched,
    isValid
  };
}

// Multiple components using the same form logic
function LoginForm() {
  const form = useFormWithValidation(
    { email: '', password: '' },
    {
      email: { required: true },
      password: { required: true, minLength: 6 }
    }
  );
  
  return (
    <form>
      <input
        value={form.values.email}
        onChange={(e) => form.setValue('email', e.target.value)}
        onBlur={() => form.setTouched('email')}
      />
      {form.touched.email && form.errors.email && (
        <span>{form.errors.email}</span>
      )}
      
      <input
        type="password"
        value={form.values.password}
        onChange={(e) => form.setValue('password', e.target.value)}
        onBlur={() => form.setTouched('password')}
      />
      {form.touched.password && form.errors.password && (
        <span>{form.errors.password}</span>
      )}
      
      <button disabled={!form.isValid}>Login</button>
    </form>
  );
}

function SignupForm() {
  const form = useFormWithValidation(
    { name: '', email: '', password: '' },
    {
      name: { required: true },
      email: { required: true },
      password: { required: true, minLength: 8 }
    }
  );
  
  // Same form logic, different fields
  return (
    <form>
      {/* Similar structure with different fields */}
    </form>
  );
}

// Benefits of custom hooks over HOCs:
// 1. No wrapper components
// 2. Better composition
// 3. Easier testing
// 4. More flexible
// 5. Better TypeScript support

async function checkAuth() {
  const token = localStorage.getItem('token');
  if (!token) return null;
  
  const response = await fetch('/api/me', {
    headers: { Authorization: `Bearer ${token}` }
  });
  
  return response.ok ? response.json() : null;
}

async function authenticate(credentials) {
  const response = await fetch('/api/login', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(credentials)
  });
  
  if (!response.ok) throw new Error('Authentication failed');
  
  const { user, token } = await response.json();
  localStorage.setItem('token', token);
  return user;
}
```

---

## Quick Reference

```jsx
import { useState, useEffect, useLayoutEffect, useInsertionEffect } from 'react';

function HooksReference() {
  // State management
  const [state, setState] = useState(initialValue);
  
  // Side effects (after render)
  useEffect(() => {
    // API calls, subscriptions, async work
    return () => {
      // Cleanup
    };
  }, [dependencies]);
  
  // Synchronous effects (before paint)
  useLayoutEffect(() => {
    // DOM measurements, synchronous DOM updates
  }, [dependencies]);
  
  // CSS injection (before DOM mutations)
  useInsertionEffect(() => {
    // CSS-in-JS, dynamic styles
  }, [dependencies]);
  
  return <div>Component content</div>;
}

// Execution order:
// 1. useInsertionEffect
// 2. useLayoutEffect  
// 3. Browser paint
// 4. useEffect
```

This guide covers the essential React Hooks concepts with practical examples showing when and how to use each hook effectively!