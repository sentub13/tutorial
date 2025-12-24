# React Q&A Guide - Essential Concepts

## 1. What is React and why is it used?

**React is a JavaScript library for building user interfaces, especially web applications.**

* **Component-based**: Build encapsulated components that manage their own state
* **Declarative**: Describe what the UI should look like, React handles the how
* **Reusable**: Write once, use anywhere approach
* **Fast**: Virtual DOM makes updates efficient
* **Popular**: Huge ecosystem and community support

```jsx
// Simple React component
function Welcome() {
  return <h1>Hello, World!</h1>;
}
```

---

## 2. What is JSX and how does it work?

**JSX is a syntax extension that lets you write HTML-like code inside JavaScript.**

* **Not HTML**: It's JavaScript that looks like HTML
* **Transpiled**: Babel converts JSX to regular JavaScript
* **Expressions**: Use curly braces {} for JavaScript expressions
* **Attributes**: Use camelCase (className instead of class)

```jsx
// JSX example
const name = "John";
const element = <h1 className="greeting">Hello, {name}!</h1>;

// With expressions
const user = { firstName: "John", lastName: "Doe" };
const greeting = (
  <div>
    <h1>Welcome, {user.firstName} {user.lastName}!</h1>
    <p>Today is {new Date().toLocaleDateString()}</p>
  </div>
);
```

---

## 3. Difference between JSX and `React.createElement`

**JSX is syntactic sugar for `React.createElement` calls.**

* **JSX**: More readable and HTML-like
* **createElement**: The actual function JSX compiles to
* **Same result**: Both create the same React elements
* **Preference**: JSX is preferred for readability

```jsx
// JSX version
const element = <h1 className="greeting">Hello, World!</h1>;

// React.createElement version (what JSX compiles to)
const element = React.createElement(
  'h1',
  { className: 'greeting' },
  'Hello, World!'
);

// Complex example
// JSX
const complex = (
  <div className="container">
    <h1>Title</h1>
    <p>Content</p>
  </div>
);

// createElement equivalent
const complex = React.createElement(
  'div',
  { className: 'container' },
  React.createElement('h1', null, 'Title'),
  React.createElement('p', null, 'Content')
);
```

---

## 4. Difference between React and ReactDOM

**React creates elements, ReactDOM renders them to the browser.**

* **React**: Core library for creating components and elements
* **ReactDOM**: Renders React components to the DOM
* **Separation**: React can target different platforms (web, mobile, VR)
* **Web-specific**: ReactDOM is specifically for web browsers

```jsx
import React from 'react';
import ReactDOM from 'react-dom/client';

// React creates the component
function App() {
  return <h1>Hello, React!</h1>;
}

// ReactDOM renders it to the DOM
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
```

---

## 5. What are components in React?

**Components are reusable pieces of UI that return JSX elements.**

* **Building blocks**: Like custom HTML elements
* **Reusable**: Write once, use multiple times
* **Composable**: Combine small components into larger ones
* **Isolated**: Each component manages its own logic and state

```jsx
// Simple component
function Button() {
  return <button>Click me</button>;
}

// Component with props
function Greeting({ name }) {
  return <h1>Hello, {name}!</h1>;
}

// Using components
function App() {
  return (
    <div>
      <Greeting name="Alice" />
      <Greeting name="Bob" />
      <Button />
    </div>
  );
}
```

---

## 6. Types of components in React

**Two main types: Functional and Class components.**

* **Functional**: Simple functions that return JSX
* **Class**: ES6 classes that extend React.Component
* **Modern preference**: Functional components with hooks
* **Legacy**: Class components still supported but less common

```jsx
// Functional Component
function Welcome({ name }) {
  return <h1>Hello, {name}!</h1>;
}

// Class Component
class Welcome extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}!</h1>;
  }
}

// Both work the same way
<Welcome name="John" />
```

---

## 7. Functional vs Class components

**Functional components are simpler and more modern with hooks support.**

**Functional Components:**
* Simpler syntax
* Use hooks for state and lifecycle
* Better performance
* Easier to test

**Class Components:**
* More verbose
* Built-in lifecycle methods
* this.state and this.setState
* Legacy approach

```jsx
// Functional Component with hooks
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

// Class Component equivalent
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
```

---

## 8. What is the Virtual DOM?

**Virtual DOM is a JavaScript representation of the real DOM that React uses for efficient updates.**

* **Performance**: Faster than direct DOM manipulation
* **Diffing**: React compares old and new virtual DOM trees
* **Batching**: Multiple updates are batched together
* **Reconciliation**: Only changed elements are updated in real DOM

```jsx
// When state changes, React creates new Virtual DOM
function App() {
  const [count, setCount] = useState(0);
  
  return (
    <div>
      <h1>Count: {count}</h1>  {/* Only this updates when count changes */}
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}

// Virtual DOM process:
// 1. State changes (count: 0 → 1)
// 2. New Virtual DOM created
// 3. React diffs old vs new Virtual DOM
// 4. Only the <h1> text content updates in real DOM
```

---

## 9. What are props?

**Props are read-only data passed from parent to child components.**

* **Immutable**: Cannot be changed by the receiving component
* **Data flow**: Always flows down from parent to child
* **Function arguments**: Like parameters passed to functions
* **Any type**: Can pass strings, numbers, objects, functions

```jsx
// Parent component passing props
function App() {
  const user = { name: "Alice", age: 25 };
  
  return (
    <div>
      <Welcome name="John" age={30} />
      <UserCard user={user} onEdit={() => console.log('Edit')} />
    </div>
  );
}

// Child component receiving props
function Welcome({ name, age }) {
  return <h1>Hello {name}, you are {age} years old!</h1>;
}

function UserCard({ user, onEdit }) {
  return (
    <div>
      <p>{user.name} - {user.age}</p>
      <button onClick={onEdit}>Edit</button>
    </div>
  );
}
```

---

## 10. What is state and how is it different from props?

**State is mutable data that belongs to a component, while props are immutable data from parent.**

* **State**: Component's own data that can change
* **Props**: Data received from parent, read-only
* **Updates**: State changes trigger re-renders
* **Ownership**: State belongs to component, props come from outside

```jsx
// State example
function Counter() {
  const [count, setCount] = useState(0); // State - can change
  
  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
    </div>
  );
}

// Props example
function Display({ title, value }) { // Props - read-only
  return <h2>{title}: {value}</h2>;
}

// Using both
function App() {
  const [number, setNumber] = useState(10);
  
  return (
    <div>
      <Display title="Current Number" value={number} /> {/* Props */}
      <button onClick={() => setNumber(number + 1)}>Update</button>
    </div>
  );
}
```

---

## 11. What is the `render()` method?

**The render() method returns JSX that describes what should appear on screen.**

* **Class components**: Required method that returns JSX
* **Functional components**: The entire function is like render()
* **Pure function**: Should not modify state or cause side effects
* **Return JSX**: Must return valid JSX or null

```jsx
// Class component with render() method
class Welcome extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}!</h1>;
  }
}

// Functional component (entire function is like render)
function Welcome({ name }) {
  return <h1>Hello, {name}!</h1>;
}

// Complex render method
class UserProfile extends React.Component {
  render() {
    const { user, isLoggedIn } = this.props;
    
    if (!isLoggedIn) {
      return <p>Please log in</p>;
    }
    
    return (
      <div>
        <h2>{user.name}</h2>
        <p>{user.email}</p>
      </div>
    );
  }
}
```

---

## 12. What is the `key` prop and why is it important?

**Keys help React identify which items have changed, added, or removed in lists.**

* **Performance**: Helps React optimize re-renders
* **Identity**: Gives each element a stable identity
* **Required**: Should be unique among siblings
* **Avoid index**: Don't use array index as key when list can change

```jsx
// Good - using unique IDs as keys
function TodoList({ todos }) {
  return (
    <ul>
      {todos.map(todo => (
        <li key={todo.id}>{todo.text}</li>
      ))}
    </ul>
  );
}

// Bad - using array index (can cause issues)
function BadTodoList({ todos }) {
  return (
    <ul>
      {todos.map((todo, index) => (
        <li key={index}>{todo.text}</li> // Avoid this!
      ))}
    </ul>
  );
}

// Example with dynamic list
function ShoppingList() {
  const [items, setItems] = useState([
    { id: 1, name: 'Apples' },
    { id: 2, name: 'Bananas' }
  ]);
  
  return (
    <ul>
      {items.map(item => (
        <li key={item.id}>{item.name}</li>
      ))}
    </ul>
  );
}
```

---

## 13. What are controlled components?

**Controlled components have their form data handled by React state.**

* **React controls**: State controls the input value
* **Single source**: State is the single source of truth
* **onChange**: Update state when input changes
* **Predictable**: Easy to validate and manipulate data

```jsx
function LoginForm() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Login:', { email, password });
  };
  
  return (
    <form onSubmit={handleSubmit}>
      <input
        type="email"
        value={email}                    // Controlled by state
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Email"
      />
      <input
        type="password"
        value={password}                 // Controlled by state
        onChange={(e) => setPassword(e.target.value)}
        placeholder="Password"
      />
      <button type="submit">Login</button>
    </form>
  );
}
```

---

## 14. What are uncontrolled components?

**Uncontrolled components store their own state internally and use refs to access values.**

* **DOM controls**: DOM handles the form data
* **Refs**: Use refs to get values when needed
* **Less React**: More like traditional HTML forms
* **Use cases**: File inputs, integration with non-React libraries

```jsx
import { useRef } from 'react';

function UncontrolledForm() {
  const emailRef = useRef();
  const passwordRef = useRef();
  
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Login:', {
      email: emailRef.current.value,
      password: passwordRef.current.value
    });
  };
  
  return (
    <form onSubmit={handleSubmit}>
      <input
        ref={emailRef}                   // Uncontrolled - uses ref
        type="email"
        defaultValue="user@example.com"  // defaultValue, not value
        placeholder="Email"
      />
      <input
        ref={passwordRef}                // Uncontrolled - uses ref
        type="password"
        placeholder="Password"
      />
      <button type="submit">Login</button>
    </form>
  );
}
```

---

## 15. What are React Fragments?

**Fragments let you group multiple elements without adding extra DOM nodes.**

* **No wrapper**: Avoid unnecessary div wrappers
* **Clean DOM**: Keeps HTML structure clean
* **Two syntaxes**: `<React.Fragment>` or `<></>`
* **Keys**: Long syntax supports keys in lists

```jsx
// Without Fragment (adds extra div)
function BadExample() {
  return (
    <div>  {/* Unnecessary wrapper */}
      <h1>Title</h1>
      <p>Content</p>
    </div>
  );
}

// With Fragment (no extra DOM node)
function GoodExample() {
  return (
    <React.Fragment>
      <h1>Title</h1>
      <p>Content</p>
    </React.Fragment>
  );
}

// Short syntax
function ShortSyntax() {
  return (
    <>
      <h1>Title</h1>
      <p>Content</p>
    </>
  );
}

// Fragment with key (in lists)
function ItemList({ items }) {
  return (
    <>
      {items.map(item => (
        <React.Fragment key={item.id}>
          <h3>{item.title}</h3>
          <p>{item.description}</p>
        </React.Fragment>
      ))}
    </>
  );
}
```

---

## 16. What are synthetic events?

**Synthetic events are React's wrapper around native DOM events for cross-browser compatibility.**

* **Cross-browser**: Same API across all browsers
* **Same interface**: Same properties and methods as native events
* **Event pooling**: Reused for performance (React 16 and below)
* **preventDefault**: Works the same as native events

```jsx
function EventExample() {
  const handleClick = (e) => {
    e.preventDefault();              // Synthetic event method
    console.log('Event type:', e.type);
    console.log('Target:', e.target.value);
    console.log('Native event:', e.nativeEvent);
  };
  
  const handleChange = (e) => {
    console.log('Input value:', e.target.value);
  };
  
  return (
    <div>
      <button onClick={handleClick}>Click me</button>
      <input onChange={handleChange} placeholder="Type here" />
      <form onSubmit={handleClick}>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

// Accessing native event if needed
function NativeEventExample() {
  const handleClick = (e) => {
    console.log('Synthetic event:', e);
    console.log('Native event:', e.nativeEvent);
  };
  
  return <button onClick={handleClick}>Click</button>;
}
```

---

## 17. What is `React.StrictMode` and why is it used?

**StrictMode is a development tool that helps identify potential problems in your application.**

* **Development only**: No effect in production builds
* **Double rendering**: Helps find side effects in render methods
* **Deprecated warnings**: Warns about deprecated React features
* **Unsafe lifecycles**: Identifies unsafe lifecycle methods

```jsx
import React from 'react';
import ReactDOM from 'react-dom/client';

function App() {
  console.log('App rendered'); // Will log twice in StrictMode
  
  return (
    <div>
      <h1>My App</h1>
      <ComponentWithSideEffect />
    </div>
  );
}

// StrictMode will help catch issues in this component
function ComponentWithSideEffect() {
  const [count, setCount] = useState(0);
  
  // This side effect in render will be caught by StrictMode
  document.title = `Count: ${count}`; // Bad practice!
  
  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
    </div>
  );
}

// Wrapping app with StrictMode
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
```

---

## Quick Reference

```jsx
// Complete minimal React app
import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';

function App() {
  const [message, setMessage] = useState('Hello, React!');
  
  return (
    <div>
      <h1>{message}</h1>
      <button onClick={() => setMessage('Updated!')}>
        Update Message
      </button>
    </div>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
```

This covers all the essential React concepts you need to understand to get started with React development!