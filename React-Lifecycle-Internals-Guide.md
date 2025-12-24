# React Component Lifecycle & Internals Guide

## 🟡 3. Component Lifecycle & Internals

---

## 1. Lifecycle of class components

**Class components have three main phases: Mounting, Updating, and Unmounting with specific methods for each.**

* **Mounting**: Component is being created and inserted into DOM
* **Updating**: Component is being re-rendered as result of changes to props or state
* **Unmounting**: Component is being removed from DOM
* **Error Handling**: Component catches JavaScript errors anywhere in child component tree

```jsx
class LifecycleExample extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    console.log('1. Constructor - Initialize state');
  }
  
  static getDerivedStateFromProps(props, state) {
    console.log('2. getDerivedStateFromProps - Sync state with props');
    // Return object to update state, or null to update nothing
    return null;
  }
  
  componentDidMount() {
    console.log('3. componentDidMount - Component mounted');
    // API calls, subscriptions, DOM manipulation
    this.timer = setInterval(() => {
      this.setState(prev => ({ count: prev.count + 1 }));
    }, 1000);
  }
  
  shouldComponentUpdate(nextProps, nextState) {
    console.log('4. shouldComponentUpdate - Should re-render?');
    // Return false to prevent re-render
    return nextState.count !== this.state.count;
  }
  
  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log('5. getSnapshotBeforeUpdate - Before DOM update');
    // Capture info from DOM before update
    return { scrollPosition: window.scrollY };
  }
  
  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log('6. componentDidUpdate - After DOM update');
    // Use snapshot if needed
    if (snapshot && snapshot.scrollPosition) {
      // Restore scroll position if needed
    }
  }
  
  componentWillUnmount() {
    console.log('7. componentWillUnmount - Cleanup');
    // Cleanup subscriptions, timers, etc.
    clearInterval(this.timer);
  }
  
  static getDerivedStateFromError(error) {
    console.log('8. getDerivedStateFromError - Error boundary');
    return { hasError: true };
  }
  
  componentDidCatch(error, errorInfo) {
    console.log('9. componentDidCatch - Log error');
    // Log error to service
  }
  
  render() {
    console.log('Render - Return JSX');
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    
    return (
      <div>
        <h1>Count: {this.state.count}</h1>
        <button onClick={() => this.setState({ count: this.state.count + 1 })}>
          Increment
        </button>
      </div>
    );
  }
}

// Lifecycle order:
// MOUNTING: constructor → getDerivedStateFromProps → render → componentDidMount
// UPDATING: getDerivedStateFromProps → shouldComponentUpdate → render → getSnapshotBeforeUpdate → componentDidUpdate
// UNMOUNTING: componentWillUnmount
// ERROR: getDerivedStateFromError → componentDidCatch
```

---

## 2. Lifecycle of functional components

**Functional components use hooks to replicate lifecycle behavior with useEffect handling most lifecycle needs.**

* **Mounting**: useEffect with empty dependency array
* **Updating**: useEffect with dependencies
* **Unmounting**: useEffect cleanup function
* **No direct equivalent**: Some class methods have no direct hook equivalent

```jsx
import { useState, useEffect, useLayoutEffect, useRef } from 'react';\n\nfunction FunctionalLifecycle({ userId }) {\n  const [count, setCount] = useState(0);\n  const [user, setUser] = useState(null);\n  const mountedRef = useRef(true);\n  const prevUserId = useRef();\n  \n  // Constructor equivalent - runs once\n  useState(() => {\n    console.log('Constructor equivalent - initialize state');\n    return 0;\n  });\n  \n  // componentDidMount equivalent\n  useEffect(() => {\n    console.log('componentDidMount - component mounted');\n    \n    const timer = setInterval(() => {\n      setCount(prev => prev + 1);\n    }, 1000);\n    \n    // componentWillUnmount equivalent\n    return () => {\n      console.log('componentWillUnmount - cleanup');\n      clearInterval(timer);\n      mountedRef.current = false;\n    };\n  }, []); // Empty deps = mount/unmount only\n  \n  // componentDidUpdate equivalent\n  useEffect(() => {\n    if (prevUserId.current !== undefined) {\n      console.log('componentDidUpdate - userId changed');\n    }\n    prevUserId.current = userId;\n  }, [userId]);\n  \n  // getDerivedStateFromProps equivalent\n  useEffect(() => {\n    if (userId) {\n      fetchUser(userId).then(userData => {\n        if (mountedRef.current) {\n          setUser(userData);\n        }\n      });\n    }\n  }, [userId]);\n  \n  // getSnapshotBeforeUpdate equivalent (rare)\n  useLayoutEffect(() => {\n    const snapshot = document.documentElement.scrollTop;\n    \n    return () => {\n      // Use snapshot after update if needed\n      console.log('Scroll position before update:', snapshot);\n    };\n  });\n  \n  // shouldComponentUpdate equivalent\n  const MemoizedChild = React.memo(({ count }) => {\n    console.log('Child re-rendered');\n    return <div>Child count: {count}</div>;\n  });\n  \n  return (\n    <div>\n      <h1>Count: {count}</h1>\n      <p>User: {user?.name || 'Loading...'}</p>\n      <MemoizedChild count={count} />\n      <button onClick={() => setCount(count + 1)}>Increment</button>\n    </div>\n  );\n}\n\n// Multiple effects for different concerns\nfunction MultipleEffects() {\n  const [data, setData] = useState(null);\n  const [windowWidth, setWindowWidth] = useState(window.innerWidth);\n  \n  // Effect 1: Data fetching\n  useEffect(() => {\n    fetchData().then(setData);\n  }, []);\n  \n  // Effect 2: Window resize listener\n  useEffect(() => {\n    const handleResize = () => setWindowWidth(window.innerWidth);\n    window.addEventListener('resize', handleResize);\n    \n    return () => window.removeEventListener('resize', handleResize);\n  }, []);\n  \n  // Effect 3: Document title\n  useEffect(() => {\n    document.title = `Width: ${windowWidth}px`;\n  }, [windowWidth]);\n  \n  return (\n    <div>\n      <p>Window width: {windowWidth}px</p>\n      <p>Data: {data?.message || 'Loading...'}</p>\n    </div>\n  );\n}\n\nasync function fetchUser(userId) {\n  const response = await fetch(`/api/users/${userId}`);\n  return response.json();\n}\n\nasync function fetchData() {\n  const response = await fetch('/api/data');\n  return response.json();\n}
```

---

## 3. Difference between `componentDidMount` and `useEffect`

**componentDidMount runs once after mount, useEffect can run on mount, updates, or both depending on dependencies.**

* **componentDidMount**: Always runs once after initial render
* **useEffect**: Runs based on dependency array
* **Timing**: Both run after DOM updates (asynchronous)
* **Cleanup**: useEffect can return cleanup function

```jsx
// Class component - componentDidMount
class ClassExample extends React.Component {
  componentDidMount() {
    console.log('Runs once after mount');
    // API calls, subscriptions
    this.fetchData();
    
    // No built-in cleanup - need componentWillUnmount
    this.timer = setInterval(() => {
      console.log('Timer tick');
    }, 1000);
  }
  
  componentWillUnmount() {
    clearInterval(this.timer); // Manual cleanup
  }
  
  fetchData = async () => {
    const data = await fetch('/api/data');
    this.setState({ data });
  }
  
  render() {
    return <div>Class Component</div>;
  }
}

// Functional component - useEffect equivalents
function FunctionalExample({ userId }) {
  const [data, setData] = useState(null);\n  \n  // Equivalent to componentDidMount\n  useEffect(() => {\n    console.log('Runs once after mount');\n    fetchData();\n    \n    const timer = setInterval(() => {\n      console.log('Timer tick');\n    }, 1000);\n    \n    // Built-in cleanup\n    return () => {\n      clearInterval(timer);\n    };\n  }, []); // Empty array = mount only\n  \n  // Runs on mount AND when userId changes\n  useEffect(() => {\n    console.log('Runs on mount and userId change');\n    if (userId) {\n      fetchUserData(userId);\n    }\n  }, [userId]); // Dependency array\n  \n  // Runs after every render (like componentDidUpdate)\n  useEffect(() => {\n    console.log('Runs after every render');\n    document.title = `Data: ${data?.length || 0} items`;\n  }); // No dependency array\n  \n  const fetchData = async () => {\n    const response = await fetch('/api/data');\n    const result = await response.json();\n    setData(result);\n  };\n  \n  const fetchUserData = async (id) => {\n    const response = await fetch(`/api/users/${id}`);\n    const user = await response.json();\n    console.log('User data:', user);\n  };\n  \n  return <div>Functional Component</div>;\n}\n\n// Key differences:\n// 1. componentDidMount: Always once\n// 2. useEffect: Flexible based on dependencies\n// 3. useEffect: Built-in cleanup\n// 4. useEffect: Can have multiple effects for different concerns
```

---

## 4. Difference between `componentWillMount`, `componentDidMount`, and `getDerivedStateFromProps`

**These methods serve different purposes: componentWillMount is deprecated, componentDidMount for side effects, getDerivedStateFromProps for state synchronization.**

* **componentWillMount**: DEPRECATED - don't use
* **componentDidMount**: Side effects after initial render
* **getDerivedStateFromProps**: Sync state with props changes
* **Timing**: getDerivedStateFromProps runs before render, componentDidMount after

```jsx
class LifecycleMethods extends React.Component {\n  constructor(props) {\n    super(props);\n    this.state = {\n      count: 0,\n      derivedValue: props.initialValue || 0\n    };\n  }\n  \n  // ❌ DEPRECATED - Don't use componentWillMount\n  // componentWillMount() {\n  //   console.log('DEPRECATED - use constructor or componentDidMount');\n  // }\n  \n  // ✅ getDerivedStateFromProps - Sync state with props\n  static getDerivedStateFromProps(nextProps, prevState) {\n    console.log('getDerivedStateFromProps - before render');\n    \n    // Return object to update state, or null for no update\n    if (nextProps.initialValue !== prevState.derivedValue) {\n      return {\n        derivedValue: nextProps.initialValue\n      };\n    }\n    \n    return null; // No state update needed\n  }\n  \n  // ✅ componentDidMount - Side effects after mount\n  componentDidMount() {\n    console.log('componentDidMount - after initial render');\n    \n    // Perfect for:\n    // - API calls\n    // - DOM manipulation\n    // - Subscriptions\n    // - Timers\n    \n    this.fetchData();\n    this.setupEventListeners();\n    \n    this.timer = setInterval(() => {\n      this.setState(prev => ({ count: prev.count + 1 }));\n    }, 1000);\n  }\n  \n  componentWillUnmount() {\n    clearInterval(this.timer);\n    this.cleanupEventListeners();\n  }\n  \n  fetchData = async () => {\n    try {\n      const response = await fetch('/api/data');\n      const data = await response.json();\n      this.setState({ data });\n    } catch (error) {\n      this.setState({ error: error.message });\n    }\n  }\n  \n  setupEventListeners = () => {\n    window.addEventListener('resize', this.handleResize);\n  }\n  \n  cleanupEventListeners = () => {\n    window.removeEventListener('resize', this.handleResize);\n  }\n  \n  handleResize = () => {\n    this.setState({ windowWidth: window.innerWidth });\n  }\n  \n  render() {\n    return (\n      <div>\n        <p>Count: {this.state.count}</p>\n        <p>Derived Value: {this.state.derivedValue}</p>\n        <p>Window Width: {this.state.windowWidth}</p>\n      </div>\n    );\n  }\n}\n\n// Functional component equivalents\nfunction FunctionalEquivalent({ initialValue }) {\n  const [count, setCount] = useState(0);\n  const [data, setData] = useState(null);\n  const [windowWidth, setWindowWidth] = useState(window.innerWidth);\n  \n  // getDerivedStateFromProps equivalent\n  const [derivedValue, setDerivedValue] = useState(initialValue || 0);\n  \n  useEffect(() => {\n    setDerivedValue(initialValue || 0);\n  }, [initialValue]);\n  \n  // componentDidMount equivalent\n  useEffect(() => {\n    console.log('Mount equivalent - after initial render');\n    \n    // API calls\n    fetchData().then(setData);\n    \n    // Event listeners\n    const handleResize = () => setWindowWidth(window.innerWidth);\n    window.addEventListener('resize', handleResize);\n    \n    // Timer\n    const timer = setInterval(() => {\n      setCount(prev => prev + 1);\n    }, 1000);\n    \n    // Cleanup\n    return () => {\n      window.removeEventListener('resize', handleResize);\n      clearInterval(timer);\n    };\n  }, []);\n  \n  return (\n    <div>\n      <p>Count: {count}</p>\n      <p>Derived Value: {derivedValue}</p>\n      <p>Window Width: {windowWidth}</p>\n    </div>\n  );\n}\n\n// Summary:\n// componentWillMount: DEPRECATED - use constructor or componentDidMount\n// componentDidMount: Side effects after mount\n// getDerivedStateFromProps: State synchronization with props\n\nasync function fetchData() {\n  const response = await fetch('/api/data');\n  return response.json();\n}
```

---

## 5. What is React reconciliation?

**Reconciliation is React's algorithm for comparing virtual DOM trees and updating only what changed.**

* **Diffing algorithm**: Compares old and new virtual DOM trees
* **Minimal updates**: Only updates changed elements in real DOM
* **Key optimization**: Uses keys to identify moved/added/removed elements
* **Performance**: Makes React fast by avoiding unnecessary DOM operations

```jsx
// React reconciliation process\nfunction ReconciliationExample() {\n  const [items, setItems] = useState([\n    { id: 1, name: 'Apple' },\n    { id: 2, name: 'Banana' },\n    { id: 3, name: 'Cherry' }\n  ]);\n  \n  const [showDetails, setShowDetails] = useState(false);\n  \n  // When state changes, React creates new Virtual DOM\n  const addItem = () => {\n    setItems(prev => [...prev, { \n      id: Date.now(), \n      name: 'New Item' \n    }]);\n  };\n  \n  const removeItem = (id) => {\n    setItems(prev => prev.filter(item => item.id !== id));\n  };\n  \n  return (\n    <div>\n      <h1>Items ({items.length})</h1>\n      \n      {/* React reconciliation in action */}\n      <ul>\n        {items.map(item => (\n          <li key={item.id}> {/* Key helps reconciliation */}\n            {item.name}\n            {showDetails && <span> - ID: {item.id}</span>}\n            <button onClick={() => removeItem(item.id)}>Remove</button>\n          </li>\n        ))}\n      </ul>\n      \n      <button onClick={addItem}>Add Item</button>\n      <button onClick={() => setShowDetails(!showDetails)}>\n        {showDetails ? 'Hide' : 'Show'} Details\n      </button>\n    </div>\n  );\n}\n\n// How reconciliation works:\nfunction ReconciliationProcess() {\n  const [count, setCount] = useState(0);\n  const [color, setColor] = useState('blue');\n  \n  return (\n    <div>\n      {/* \n        When count changes:\n        1. React creates new Virtual DOM\n        2. Compares with previous Virtual DOM\n        3. Finds only <span> content changed\n        4. Updates only that text node in real DOM\n      */}\n      <h1>Counter App</h1>\n      <span style={{ color }}>Count: {count}</span>\n      \n      {/* \n        When color changes:\n        1. React compares Virtual DOMs\n        2. Finds only style attribute changed\n        3. Updates only the style in real DOM\n      */}\n      \n      <div>\n        <button onClick={() => setCount(count + 1)}>+</button>\n        <button onClick={() => setColor(color === 'blue' ? 'red' : 'blue')}>\n          Change Color\n        </button>\n      </div>\n    </div>\n  );\n}\n\n// Reconciliation rules:\nfunction ReconciliationRules() {\n  const [showList, setShowList] = useState(true);\n  const [items, setItems] = useState(['A', 'B', 'C']);\n  \n  return (\n    <div>\n      {/* Rule 1: Different element types = complete rebuild */}\n      {showList ? (\n        <ul>\n          {items.map((item, index) => <li key={index}>{item}</li>)}\n        </ul>\n      ) : (\n        <ol>\n          {items.map((item, index) => <li key={index}>{item}</li>)}\n        </ol>\n      )}\n      \n      {/* Rule 2: Same element type = compare attributes */}\n      <div className={showList ? 'list-view' : 'grid-view'}>\n        Content here\n      </div>\n      \n      {/* Rule 3: Keys help identify moved elements */}\n      <ul>\n        {items.map(item => (\n          <li key={item}>{item}</li> // Good - stable key\n        ))}\n      </ul>\n      \n      <button onClick={() => setShowList(!showList)}>Toggle View</button>\n      <button onClick={() => setItems(['C', 'A', 'B'])}>\n        Reorder Items\n      </button>\n    </div>\n  );\n}\n\n// Reconciliation optimization with React.memo\nconst OptimizedChild = React.memo(({ name, details }) => {\n  console.log(`Rendering child: ${name}`);\n  \n  return (\n    <div>\n      <h3>{name}</h3>\n      {details && <p>{details}</p>}\n    </div>\n  );\n});\n\nfunction OptimizedParent() {\n  const [count, setCount] = useState(0);\n  const [name] = useState('John');\n  const [details] = useState('Some details');\n  \n  return (\n    <div>\n      <p>Count: {count}</p>\n      <button onClick={() => setCount(count + 1)}>Increment</button>\n      \n      {/* This won't re-render when count changes */}\n      <OptimizedChild name={name} details={details} />\n    </div>\n  );\n}
```

---

## 6. What is React Fiber?

**React Fiber is the new reconciliation algorithm that enables incremental rendering and better performance.**

* **Incremental rendering**: Break work into chunks, pause and resume
* **Priority-based**: High priority updates interrupt low priority ones
* **Better UX**: Keeps UI responsive during heavy computations
* **Concurrent features**: Enables Suspense, concurrent mode, time slicing

```jsx\nimport { useState, useTransition, useDeferredValue } from 'react';\n\n// React Fiber enables these concurrent features\nfunction FiberExample() {\n  const [query, setQuery] = useState('');\n  const [items, setItems] = useState(generateItems(10000));\n  const [isPending, startTransition] = useTransition();\n  \n  // Deferred value - lower priority update\n  const deferredQuery = useDeferredValue(query);\n  \n  // Filter items based on deferred query\n  const filteredItems = items.filter(item => \n    item.name.toLowerCase().includes(deferredQuery.toLowerCase())\n  );\n  \n  const handleSearch = (value) => {\n    setQuery(value); // High priority - immediate\n    \n    // Low priority - can be interrupted\n    startTransition(() => {\n      // Expensive operation that won't block UI\n      const newItems = generateItems(20000);\n      setItems(newItems);\n    });\n  };\n  \n  return (\n    <div>\n      <h1>React Fiber Demo</h1>\n      \n      {/* Input stays responsive */}\n      <input\n        value={query}\n        onChange={(e) => handleSearch(e.target.value)}\n        placeholder=\"Search items...\"\n      />\n      \n      {isPending && <div>Updating items...</div>}\n      \n      {/* List updates with lower priority */}\n      <div style={{ opacity: isPending ? 0.7 : 1 }}>\n        <p>Found {filteredItems.length} items</p>\n        <ul>\n          {filteredItems.slice(0, 100).map(item => (\n            <li key={item.id}>{item.name}</li>\n          ))}\n        </ul>\n      </div>\n    </div>\n  );\n}\n\n// Fiber work phases\nfunction FiberPhases() {\n  const [count, setCount] = useState(0);\n  const [heavyList, setHeavyList] = useState([]);\n  \n  const updateHeavyList = () => {\n    // This would block UI in old React\n    // Fiber can pause/resume this work\n    const newList = [];\n    for (let i = 0; i < 10000; i++) {\n      newList.push({\n        id: i,\n        value: Math.random(),\n        computed: expensiveComputation(i)\n      });\n    }\n    setHeavyList(newList);\n  };\n  \n  return (\n    <div>\n      {/* High priority - stays responsive */}\n      <button onClick={() => setCount(count + 1)}>\n        Count: {count} (High Priority)\n      </button>\n      \n      {/* Low priority - can be interrupted */}\n      <button onClick={updateHeavyList}>\n        Update Heavy List (Low Priority)\n      </button>\n      \n      <div>\n        {heavyList.slice(0, 50).map(item => (\n          <div key={item.id}>\n            Item {item.id}: {item.computed}\n          </div>\n        ))}\n      </div>\n    </div>\n  );\n}\n\n// Fiber enables Suspense\nfunction SuspenseExample() {\n  return (\n    <div>\n      <h1>Suspense with Fiber</h1>\n      <React.Suspense fallback={<div>Loading...</div>}>\n        <LazyComponent />\n      </React.Suspense>\n    </div>\n  );\n}\n\nconst LazyComponent = React.lazy(() => \n  import('./LazyComponent').catch(() => ({\n    default: () => <div>Failed to load component</div>\n  }))\n);\n\n// Fiber benefits:\n// 1. Incremental rendering - work can be paused/resumed\n// 2. Priority-based updates - urgent updates interrupt less urgent ones\n// 3. Better error boundaries - errors don't crash entire app\n// 4. Concurrent features - Suspense, time slicing, etc.\n// 5. Better performance - smoother animations and interactions\n\nfunction generateItems(count) {\n  return Array.from({ length: count }, (_, i) => ({\n    id: i,\n    name: `Item ${i}`,\n    value: Math.random()\n  }));\n}\n\nfunction expensiveComputation(n) {\n  // Simulate expensive computation\n  let result = 0;\n  for (let i = 0; i < 1000; i++) {\n    result += Math.sin(n + i);\n  }\n  return result.toFixed(2);\n}
```

---

## 7. What causes a component to re-render?

**Components re-render when state changes, props change, parent re-renders, or context changes.**

* **State changes**: useState, useReducer updates trigger re-render
* **Props changes**: New props from parent cause re-render
* **Parent re-renders**: Child components re-render by default
* **Context changes**: useContext consumers re-render when context updates

```jsx
import { useState, useContext, createContext, memo, useCallback } from 'react';\n\nconst ThemeContext = createContext();\n\nfunction ReRenderExample() {\n  const [count, setCount] = useState(0);\n  const [name, setName] = useState('John');\n  const [theme, setTheme] = useState('light');\n  \n  console.log('Parent re-rendered');\n  \n  return (\n    <ThemeContext.Provider value={{ theme, setTheme }}>\n      <div>\n        <h1>Re-render Causes</h1>\n        \n        {/* Cause 1: State change */}\n        <p>Count: {count}</p>\n        <button onClick={() => setCount(count + 1)}>\n          Increment (causes re-render)\n        </button>\n        \n        {/* Cause 2: Props change */}\n        <ChildWithProps name={name} count={count} />\n        \n        {/* Cause 3: Parent re-render */}\n        <ChildWithoutProps />\n        \n        {/* Cause 4: Context change */}\n        <ChildUsingContext />\n        \n        <input \n          value={name} \n          onChange={(e) => setName(e.target.value)}\n          placeholder=\"Change name\"\n        />\n        \n        <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>\n          Toggle Theme\n        </button>\n      </div>\n    </ThemeContext.Provider>\n  );\n}\n\n// Child that re-renders when props change\nfunction ChildWithProps({ name, count }) {\n  console.log('ChildWithProps re-rendered');\n  \n  return (\n    <div>\n      <h3>Child with Props</h3>\n      <p>Name: {name}, Count: {count}</p>\n    </div>\n  );\n}\n\n// Child that re-renders when parent re-renders (even with no props)\nfunction ChildWithoutProps() {\n  console.log('ChildWithoutProps re-rendered');\n  \n  return (\n    <div>\n      <h3>Child without Props</h3>\n      <p>I re-render when parent re-renders!</p>\n    </div>\n  );\n}\n\n// Child that re-renders when context changes\nfunction ChildUsingContext() {\n  const { theme } = useContext(ThemeContext);\n  console.log('ChildUsingContext re-rendered');\n  \n  return (\n    <div style={{ background: theme === 'light' ? 'white' : 'black', color: theme === 'light' ? 'black' : 'white' }}>\n      <h3>Child using Context</h3>\n      <p>Current theme: {theme}</p>\n    </div>\n  );\n}\n\n// Preventing unnecessary re-renders\nfunction OptimizedExample() {\n  const [count, setCount] = useState(0);\n  const [name, setName] = useState('John');\n  const [items, setItems] = useState(['A', 'B', 'C']);\n  \n  // Memoized callback to prevent child re-renders\n  const handleItemClick = useCallback((item) => {\n    console.log('Item clicked:', item);\n  }, []);\n  \n  const addItem = () => {\n    setItems(prev => [...prev, `Item ${prev.length + 1}`]);\n  };\n  \n  return (\n    <div>\n      <h1>Optimized Re-renders</h1>\n      \n      <p>Count: {count}</p>\n      <button onClick={() => setCount(count + 1)}>Increment</button>\n      \n      {/* This won't re-render when count changes */}\n      <MemoizedChild name={name} onItemClick={handleItemClick} />\n      \n      {/* This will re-render when items change */}\n      <ItemList items={items} onItemClick={handleItemClick} />\n      \n      <input \n        value={name} \n        onChange={(e) => setName(e.target.value)}\n        placeholder=\"Change name\"\n      />\n      \n      <button onClick={addItem}>Add Item</button>\n    </div>\n  );\n}\n\n// Memoized component - only re-renders when props actually change\nconst MemoizedChild = memo(({ name, onItemClick }) => {\n  console.log('MemoizedChild re-rendered');\n  \n  return (\n    <div>\n      <h3>Memoized Child</h3>\n      <p>Name: {name}</p>\n      <button onClick={() => onItemClick('test')}>Click me</button>\n    </div>\n  );\n});\n\n// Component that re-renders when items prop changes\nconst ItemList = memo(({ items, onItemClick }) => {\n  console.log('ItemList re-rendered');\n  \n  return (\n    <div>\n      <h3>Item List</h3>\n      <ul>\n        {items.map(item => (\n          <li key={item} onClick={() => onItemClick(item)}>\n            {item}\n          </li>\n        ))}\n      </ul>\n    </div>\n  );\n});\n\n// Force re-render example\nfunction ForceReRenderExample() {\n  const [, forceRender] = useState({});\n  \n  // Force re-render by updating state with new object\n  const forceReRender = () => {\n    forceRender({}); // New object reference triggers re-render\n  };\n  \n  console.log('Component rendered at:', new Date().toLocaleTimeString());\n  \n  return (\n    <div>\n      <h3>Force Re-render</h3>\n      <p>Last rendered: {new Date().toLocaleTimeString()}</p>\n      <button onClick={forceReRender}>Force Re-render</button>\n    </div>\n  );\n}\n\n// Summary of re-render causes:\n// 1. State changes (useState, useReducer)\n// 2. Props changes (new props from parent)\n// 3. Parent re-renders (unless memoized)\n// 4. Context changes (useContext)\n// 5. Force re-render (new object/array references)
```

---

## Quick Reference

```jsx
// Class Component Lifecycle Order
// MOUNTING: constructor → getDerivedStateFromProps → render → componentDidMount
// UPDATING: getDerivedStateFromProps → shouldComponentUpdate → render → getSnapshotBeforeUpdate → componentDidUpdate
// UNMOUNTING: componentWillUnmount
// ERROR: getDerivedStateFromError → componentDidCatch

// Functional Component Lifecycle with Hooks
useEffect(() => {
  // componentDidMount
  return () => {
    // componentWillUnmount
  };
}, []); // Empty deps = mount/unmount only

useEffect(() => {
  // componentDidUpdate
}, [dependency]); // Runs when dependency changes

// Re-render Triggers
// 1. State changes: setState, useState, useReducer
// 2. Props changes: New props from parent
// 3. Parent re-renders: Unless component is memoized
// 4. Context changes: useContext value updates
// 5. Force re-render: New object references

// Reconciliation Process
// 1. State/props change
// 2. Create new Virtual DOM
// 3. Compare with previous Virtual DOM (diffing)
// 4. Update only changed elements in real DOM

// React Fiber Benefits
// - Incremental rendering (pausable/resumable work)
// - Priority-based updates
// - Better performance and user experience
// - Enables concurrent features (Suspense, time slicing)
```

This comprehensive guide covers all aspects of React component lifecycles, internals, and performance optimization concepts!