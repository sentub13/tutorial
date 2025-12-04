1. What is JavaScript?
JavaScript is a lightweight, interpreted programming language primarily used to make web pages interactive. It runs in the browser and allows you to create dynamic content, handle events, and build complex web applications.

2. What are the different data types in JavaScript?
JavaScript has two main types: primitive and non-primitive. Primitive types include string, number, boolean, null, undefined, and symbol. Non-primitive types include object, array, set, and map.

3. What is the difference between let, const, and var?
var is function-scoped and can be redeclared. let is block-scoped and cannot be redeclared. const is also block-scoped but is used for variables that should not be reassigned.

4. What is a closure in JavaScript?
A closure is a function that remembers the variables from its outer scope, even after the outer function has finished executing. It’s useful for creating private variables or function factories.

5. What is the difference between == and === in JavaScript?
== checks for value equality and performs type coercion, while === checks for both value and type equality. Always use === for stricter comparisons.

6. Explain the concept of “truthy” and “falsy” values in JavaScript.
Truthy values are treated as true in a boolean context, like non-empty strings or non-zero numbers. Falsy values include false, 0, "", null, undefined, and NaN.

7. What is the difference between null and undefined?
null is an intentional absence of value, while undefined means a variable has been declared but not assigned a value.

8. What is the undefined value in JavaScript?
undefined is a primitive value automatically assigned to variables that are declared but not initialized or to function parameters with no arguments.

9. What is the difference between synchronous and asynchronous code in JavaScript?
Synchronous code runs line by line, blocking further execution until the current task is complete. Asynchronous code allows other tasks to run while waiting for operations like API calls or timers to finish.

10. What are the different ways to create objects in JavaScript?
You can create objects using object literals ({}), the new Object() constructor, classes, or Object.create().

11. What is hoisting in JavaScript?
Hoisting is JavaScript’s behavior of moving variable and function declarations to the top of their scope during the compilation phase. However, only declarations are hoisted, not initializations.

12. What is a pure function in JavaScript? Can you give an example?
A pure function always produces the same output for the same input and has no side effects. Example: const add = (a, b) => a + b;.

13. What are higher-order functions in JavaScript?
Higher-order functions are functions that take other functions as arguments, return functions, or both. Examples include map, filter, and reduce.

14. What is the difference between call(), apply(), and bind()?
call() invokes a function with arguments passed individually. apply() is similar but takes arguments as an array. bind() returns a new function with a specific this context.

15. What are closures in JavaScript, and why are they important?
Closures are functions that retain access to their outer scope variables. They’re important for data encapsulation and creating private variables.

16. How does the this keyword work in JavaScript?
this refers to the context in which a function is called. In a method, it refers to the object. In a regular function, it refers to the global object or undefined in strict mode.

17. What is the difference between setTimeout and setInterval?
setTimeout runs a function once after a delay, while setInterval repeatedly runs a function at specified intervals.

18. What is the event loop in JavaScript?
The event loop is a mechanism that handles asynchronous operations by continuously checking the call stack and the task queue to execute code in the correct order.

19. What is the difference between map() and forEach()?
map() creates a new array by transforming each element, while forEach() simply iterates over elements without returning anything.

20. What is the difference between var, let, and const?
var is function-scoped, while let and const are block-scoped. const is used for variables that should not be reassigned.

21. What are promises in JavaScript?
Promises are objects that represent the eventual completion or failure of an asynchronous operation. They have three states: pending, fulfilled, and rejected.

22. What are the states of a promise?
A promise has three states: pending (in progress), fulfilled (completed successfully), and rejected (failed).

23. What is the difference between async and await in JavaScript?
async is used to declare a function that returns a promise. await pauses the execution of an async function until the promise resolves.

24. What is the difference between Object.freeze() and Object.seal()?
Object.freeze() makes an object immutable, while Object.seal() prevents adding or removing properties but allows modifying existing ones.

25. What is the difference between slice() and splice()?
slice() returns a shallow copy of an array without modifying the original. splice() modifies the original array by adding or removing elements.

26. What is the difference between == and ===?
== checks for value equality with type coercion, while === checks for both value and type equality.

27. What is the difference between function and arrow function?
Arrow functions have a shorter syntax and do not have their own this context, making them unsuitable for methods.

28. What is the difference between JSON.stringify() and JSON.parse()?
JSON.stringify() converts a JavaScript object to a JSON string, while JSON.parse() converts a JSON string back to a JavaScript object.

29. What is the difference between localStorage and sessionStorage?
localStorage persists data even after the browser is closed, while sessionStorage clears data when the tab or browser is closed.

30. What is the difference between call(), apply(), and bind()?
call() invokes a function with arguments passed individually. apply() takes arguments as an array. bind() returns a new function with a specific this context.

JavaScript Interview Questions and Answers (31–60)
31. What is the difference between window and document in JavaScript?
The window object represents the browser window, while the document object represents the content of the web page. window is the global object, and document is part of it.

32. What is event delegation in JavaScript?
Event delegation is a technique where a single event listener is added to a parent element to handle events for its child elements. It works by taking advantage of event bubbling.

33. How do you prevent the default action of an event in JavaScript?
You can use the event.preventDefault() method to stop the default behavior of an event, like preventing a form submission or a link from navigating.

34. What is the difference between stopPropagation() and stopImmediatePropagation()?
stopPropagation() stops the event from bubbling up, while stopImmediatePropagation() stops the event from bubbling and prevents other listeners on the same element from being executed.

35. What is the concept of memoization in JavaScript?
Memoization is an optimization technique where the results of expensive function calls are cached. If the function is called again with the same arguments, the cached result is returned.

36. What is the difference between throttling and debouncing?
Throttling ensures a function is called at most once in a specified time interval. Debouncing delays the function call until after a specified time has passed since the last event.

37. What is the difference between Object.keys(), Object.values(), and Object.entries()?
Object.keys() returns an array of the object's keys, Object.values() returns an array of the object's values, and Object.entries() returns an array of key-value pairs.

38. What is the difference between for...in and for...of loops?
for...in iterates over the keys of an object, while for...of iterates over the values of an iterable, like an array or a string.

39. What is the difference between shallow copy and deep copy in JavaScript?
A shallow copy copies only the first level of an object, while a deep copy recursively copies all levels of an object. Libraries like lodash can help create deep copies.

40. What is the difference between null and undefined?
null is an intentional absence of value, while undefined means a variable has been declared but not assigned a value.

41. What is the difference between synchronous and asynchronous code?
Synchronous code runs line by line, blocking further execution until the current task is complete. Asynchronous code allows other tasks to run while waiting for operations like API calls or timers to finish.

42. What is the difference between setTimeout and setInterval?
setTimeout runs a function once after a delay, while setInterval repeatedly runs a function at specified intervals.

43. What is the event loop in JavaScript?
The event loop is a mechanism that handles asynchronous operations by continuously checking the call stack and the task queue to execute code in the correct order.

44. What is the difference between map() and forEach()?
map() creates a new array by transforming each element, while forEach() simply iterates over elements without returning anything.

45. What is the difference between var, let, and const?
var is function-scoped, while let and const are block-scoped. const is used for variables that should not be reassigned.

46. What are promises in JavaScript?
Promises are objects that represent the eventual completion or failure of an asynchronous operation. They have three states: pending, fulfilled, and rejected.

47. What are the states of a promise?
A promise has three states: pending (in progress), fulfilled (completed successfully), and rejected (failed).

48. What is the difference between async and await in JavaScript?
async is used to declare a function that returns a promise. await pauses the execution of an async function until the promise resolves.

49. What is the difference between Object.freeze() and Object.seal()?
Object.freeze() makes an object immutable, while Object.seal() prevents adding or removing properties but allows modifying existing ones.

50. What is the difference between slice() and splice()?
slice() returns a shallow copy of an array without modifying the original. splice() modifies the original array by adding or removing elements.

51. What is the difference between == and ===?
== checks for value equality with type coercion, while === checks for both value and type equality.

52. What is the difference between function and arrow function?
Arrow functions have a shorter syntax and do not have their own this context, making them unsuitable for methods.

53. What is the difference between JSON.stringify() and JSON.parse()?
JSON.stringify() converts a JavaScript object to a JSON string, while JSON.parse() converts a JSON string back to a JavaScript object.

54. What is the difference between localStorage and sessionStorage?
localStorage persists data even after the browser is closed, while sessionStorage clears data when the tab or browser is closed.

55. What is the difference between call(), apply(), and bind()?
call() invokes a function with arguments passed individually. apply() takes arguments as an array. bind() returns a new function with a specific this context.

56. What is the difference between window and document in JavaScript?
The window object represents the browser window, while the document object represents the content of the web page. window is the global object, and document is part of it.

57. What is event delegation in JavaScript?
Event delegation is a technique where a single event listener is added to a parent element to handle events for its child elements. It works by taking advantage of event bubbling.

58. How do you prevent the default action of an event in JavaScript?
You can use the event.preventDefault() method to stop the default behavior of an event, like preventing a form submission or a link from navigating.

59. What is the difference between stopPropagation() and stopImmediatePropagation()?
stopPropagation() stops the event from bubbling up, while stopImmediatePropagation() stops the event from bubbling and prevents other listeners on the same element from being executed.

60. What is the concept of memoization in JavaScript?
Memoization is an optimization technique where the results of expensive function calls are cached. If the function is called again with the same arguments, the cached result is returned.

61. What is the difference between undefined and not defined in JavaScript?
undefined means a variable has been declared but not assigned a value. not defined means the variable hasn’t been declared at all and will throw a ReferenceError if accessed.

62. What is the difference between typeof and instanceof in JavaScript?
typeof checks the data type of a variable and returns a string, while instanceof checks if an object is an instance of a specific class or constructor.

63. What is the difference between apply() and call() in JavaScript?
Both invoke a function with a specific this context, but apply() takes arguments as an array, while call() takes arguments individually.

64. What is the difference between Object.create() and class inheritance?
Object.create() creates an object with a specified prototype, while class inheritance uses the class keyword to define a blueprint for creating objects.

65. What is the difference between hasOwnProperty() and in?
hasOwnProperty() checks if a property exists directly on an object, while in checks if a property exists on the object or its prototype chain.

66. What is the difference between Object.assign() and the spread operator?
Both copy properties from one object to another, but Object.assign() is a method, while the spread operator (...) is a syntax feature.

67. What is the difference between Array.map() and Array.filter()?
map() transforms each element of an array and returns a new array, while filter() returns a new array containing only the elements that satisfy a condition.

68. What is the difference between Array.reduce() and Array.forEach()?
reduce() accumulates a single value by iterating over an array, while forEach() simply iterates over the array without returning anything.

69. What is the difference between == and === in JavaScript?
== checks for value equality with type coercion, while === checks for both value and type equality.

70. What is the difference between null and undefined?
null is an intentional absence of value, while undefined means a variable has been declared but not assigned a value.

71. What is the difference between let, const, and var?
var is function-scoped, while let and const are block-scoped. const is used for variables that should not be reassigned.

72. What is the difference between Object.freeze() and Object.seal()?
Object.freeze() makes an object immutable, while Object.seal() prevents adding or removing properties but allows modifying existing ones.

73. What is the difference between setTimeout() and setInterval()?
setTimeout() runs a function once after a delay, while setInterval() repeatedly runs a function at specified intervals.

74. What is the difference between synchronous and asynchronous code?
Synchronous code runs line by line, blocking further execution until the current task is complete. Asynchronous code allows other tasks to run while waiting for operations like API calls or timers to finish.

75. What is the difference between window and document in JavaScript?
The window object represents the browser window, while the document object represents the content of the web page. window is the global object, and document is part of it.

76. What is the difference between for...in and for...of loops?
for...in iterates over the keys of an object, while for...of iterates over the values of an iterable, like an array or a string.

77. What is the difference between Array.slice() and Array.splice()?
slice() returns a shallow copy of an array without modifying the original. splice() modifies the original array by adding or removing elements.

78. What is the difference between JSON.stringify() and JSON.parse()?
JSON.stringify() converts a JavaScript object to a JSON string, while JSON.parse() converts a JSON string back to a JavaScript object.

79. What is the difference between localStorage and sessionStorage?
localStorage persists data even after the browser is closed, while sessionStorage clears data when the tab or browser is closed.

80. What is the difference between call(), apply(), and bind()?
call() invokes a function with arguments passed individually. apply() takes arguments as an array. bind() returns a new function with a specific this context.

81. What is the difference between typeof and instanceof?
typeof checks the data type of a variable and returns a string, while instanceof checks if an object is an instance of a specific class or constructor.

82. What is the difference between Object.keys() and Object.values()?
Object.keys() returns an array of the object's keys, while Object.values() returns an array of the object's values.

83. What is the difference between Array.map() and Array.forEach()?
map() creates a new array by transforming each element, while forEach() simply iterates over elements without returning anything.

84. What is the difference between Array.filter() and Array.reduce()?
filter() returns a new array containing only the elements that satisfy a condition, while reduce() accumulates a single value by iterating over an array.

85. What is the difference between Object.create() and Object.assign()?
Object.create() creates an object with a specified prototype, while Object.assign() copies properties from one object to another.

86. What is the difference between Object.freeze() and Object.defineProperty()?
Object.freeze() makes an object immutable, while Object.defineProperty() allows you to define or modify specific properties of an object.

87. What is the difference between Array.push() and Array.concat()?
push() adds elements to the end of an array and modifies the original array, while concat() creates a new array by combining arrays or values.

88. What is the difference between Array.pop() and Array.shift()?
pop() removes the last element of an array, while shift() removes the first element.

89. What is the difference between Array.unshift() and Array.push()?
unshift() adds elements to the beginning of an array, while push() adds elements to the end.

90. What are design patterns in JavaScript?
Design patterns are reusable solutions to common software design problems. Examples include Singleton, Module, Observer, Factory, Prototype, Decorator, and Command patterns. They help structure code efficiently.

91. What is the difference between Array.includes() and Array.indexOf()?
Array.includes() checks if an array contains a specific value and returns true or false. Array.indexOf() returns the index of the value if found, or -1 if not.

92. What is the difference between Array.find() and Array.filter()?
Array.find() returns the first element that satisfies a condition, while Array.filter() returns all elements that satisfy the condition as a new array.

93. What is the difference between Array.some() and Array.every()?
Array.some() checks if at least one element satisfies a condition, while Array.every() checks if all elements satisfy the condition.

94. What is the difference between Object.entries() and Object.fromEntries()?
Object.entries() converts an object into an array of key-value pairs, while Object.fromEntries() converts an array of key-value pairs back into an object.

95. What is the difference between Array.sort() and Array.reverse()?
Array.sort() sorts the elements of an array based on a comparison function, while Array.reverse() reverses the order of the elements in the array.

96. What is the difference between Array.flat() and Array.flatMap()?
Array.flat() flattens nested arrays into a single array, while Array.flatMap() first maps each element and then flattens the result.

97. What is the difference between Object.defineProperty() and Object.defineProperties()?
Object.defineProperty() defines a single property on an object, while Object.defineProperties() defines multiple properties at once.

98. What is the difference between Object.getOwnPropertyDescriptor() and Object.getOwnPropertyDescriptors()?
Object.getOwnPropertyDescriptor() retrieves the descriptor of a single property, while Object.getOwnPropertyDescriptors() retrieves descriptors for all properties of an object.

99. What is the difference between Object.seal() and Object.preventExtensions()?
Object.seal() prevents adding or removing properties but allows modifying existing ones. Object.preventExtensions() only prevents adding new properties.

100. What is the difference between Object.is() and ===?
Object.is() is similar to === but treats NaN as equal to NaN and +0 as not equal to -0.

101. What is the difference between Array.reduce() and Array.reduceRight()?
Array.reduce() processes elements from left to right, while Array.reduceRight() processes elements from right to left.

102. What is the difference between Array.concat() and the spread operator?
Both combine arrays, but Array.concat() is a method, while the spread operator (...) is a syntax feature.

103. What is the difference between Array.fill() and Array.from()?
Array.fill() fills an array with a static value, while Array.from() creates a new array from an iterable or array-like object.

104. What is the difference between Array.keys(), Array.values(), and Array.entries()?
Array.keys() returns an iterator for the array's keys, Array.values() returns an iterator for the values, and Array.entries() returns an iterator for key-value pairs.

105. What is the difference between Function.prototype.call() and Function.prototype.bind()?
call() invokes a function immediately with a specific this context, while bind() returns a new function with the this context bound.

106. What is the difference between Object.assign() and Object.create()?
Object.assign() copies properties from one object to another, while Object.create() creates a new object with a specified prototype.

107. What is the difference between Object.freeze() and Object.preventExtensions()?
Object.freeze() makes an object immutable, while Object.preventExtensions() only prevents adding new properties.

108. What is the difference between Array.findIndex() and Array.indexOf()?
Array.findIndex() returns the index of the first element that satisfies a condition, while Array.indexOf() returns the index of a specific value.

109. What is the difference between Array.map() and Array.flatMap()?
Array.map() transforms each element of an array, while Array.flatMap() transforms each element and flattens the result into a single array.

110. What is the difference between Object.getPrototypeOf() and Object.setPrototypeOf()?
Object.getPrototypeOf() retrieves the prototype of an object, while Object.setPrototypeOf() sets the prototype of an object.

111. What is the difference between Object.keys() and Object.getOwnPropertyNames()?
Object.keys() returns only enumerable properties, while Object.getOwnPropertyNames() returns all properties, including non-enumerable ones.

112. What is the difference between Array.splice() and Array.slice()?
Array.splice() modifies the original array by adding or removing elements, while Array.slice() creates a shallow copy of a portion of the array.

113. What is the difference between Object.hasOwn() and Object.hasOwnProperty()?
Object.hasOwn() is a newer method that checks if an object has a property directly, while Object.hasOwnProperty() is the older equivalent.

114. What is the difference between Array.filter() and Array.some()?
Array.filter() returns all elements that satisfy a condition, while Array.some() checks if at least one element satisfies the condition.

115. What is the difference between Array.every() and Array.some()?
Array.every() checks if all elements satisfy a condition, while Array.some() checks if at least one element satisfies the condition.

116. What is the difference between Object.isFrozen() and Object.isSealed()?
Object.isFrozen() checks if an object is immutable, while Object.isSealed() checks if an object is sealed (no new properties can be added).

117. What is the difference between Object.entries() and Object.keys()?
Object.entries() returns an array of key-value pairs, while Object.keys() returns an array of keys.

118. What is the difference between Array.push() and Array.unshift()?
Array.push() adds elements to the end of an array, while Array.unshift() adds elements to the beginning.

119. What is the difference between Array.pop() and Array.shift()?
Array.pop() removes the last element of an array, while Array.shift() removes the first element.

120. What are design patterns in JavaScript?
Design patterns are reusable solutions to common software design problems. Examples include Singleton, Module, Observer, Factory, Prototype, Decorator, and Command patterns. They help structure code efficiently and solve problems in a reusable way.

121. What is the difference between Object.freeze() and Object.seal()?
Object.freeze() makes an object completely immutable, meaning you cannot add, remove, or modify properties. Object.seal() prevents adding or removing properties but allows modifying existing ones.

122. What is the difference between Array.map() and Array.forEach()?
Array.map() creates a new array by applying a function to each element, while Array.forEach() simply iterates over the array without returning anything.

123. What is the difference between Array.filter() and Array.find()?
Array.filter() returns all elements that satisfy a condition as a new array, while Array.find() returns only the first element that satisfies the condition.

124. What is the difference between Array.some() and Array.every()?
Array.some() checks if at least one element satisfies a condition, while Array.every() checks if all elements satisfy the condition.

125. What is the difference between Object.keys() and Object.entries()?
Object.keys() returns an array of the object's keys, while Object.entries() returns an array of key-value pairs.

126. What is the difference between Object.create() and Object.assign()?
Object.create() creates a new object with a specified prototype, while Object.assign() copies properties from one or more source objects to a target object.

127. What is the difference between Object.getPrototypeOf() and Object.setPrototypeOf()?
Object.getPrototypeOf() retrieves the prototype of an object, while Object.setPrototypeOf() sets the prototype of an object.

128. What is the difference between Object.defineProperty() and Object.defineProperties()?
Object.defineProperty() defines a single property on an object, while Object.defineProperties() defines multiple properties at once.

129. What is the difference between Object.is() and ===?
Object.is() is similar to === but treats NaN as equal to NaN and +0 as not equal to -0.

130. What is the difference between Array.reduce() and Array.reduceRight()?
Array.reduce() processes elements from left to right, while Array.reduceRight() processes elements from right to left.

131. What is the difference between Array.concat() and the spread operator?
Both combine arrays, but Array.concat() is a method, while the spread operator (...) is a syntax feature.

132. What is the difference between Array.fill() and Array.from()?
Array.fill() fills an array with a static value, while Array.from() creates a new array from an iterable or array-like object.

133. What is the difference between Array.keys(), Array.values(), and Array.entries()?
Array.keys() returns an iterator for the array's keys, Array.values() returns an iterator for the values, and Array.entries() returns an iterator for key-value pairs.

134. What is the difference between Function.prototype.call() and Function.prototype.apply()?
Both invoke a function with a specific this context, but call() takes arguments individually, while apply() takes arguments as an array.

135. What is the difference between Object.freeze() and Object.preventExtensions()?
Object.freeze() makes an object immutable, while Object.preventExtensions() only prevents adding new properties.

136. What is the difference between Array.findIndex() and Array.indexOf()?
Array.findIndex() returns the index of the first element that satisfies a condition, while Array.indexOf() returns the index of a specific value.

137. What is the difference between Array.map() and Array.flatMap()?
Array.map() transforms each element of an array, while Array.flatMap() transforms each element and flattens the result into a single array.

138. What is the difference between Object.getOwnPropertyDescriptor() and Object.getOwnPropertyDescriptors()?
Object.getOwnPropertyDescriptor() retrieves the descriptor of a single property, while Object.getOwnPropertyDescriptors() retrieves descriptors for all properties of an object.

139. What is the difference between Object.seal() and Object.preventExtensions()?
Object.seal() prevents adding or removing properties but allows modifying existing ones. Object.preventExtensions() only prevents adding new properties.

140. What is the difference between Object.entries() and Object.keys()?
Object.entries() returns an array of key-value pairs, while Object.keys() returns an array of keys.

141. What is the difference between Array.push() and Array.unshift()?
Array.push() adds elements to the end of an array, while Array.unshift() adds elements to the beginning.

142. What is the difference between Array.pop() and Array.shift()?
Array.pop() removes the last element of an array, while Array.shift() removes the first element.

143. What is the difference between Object.hasOwn() and Object.hasOwnProperty()?
Object.hasOwn() is a newer method that checks if an object has a property directly, while Object.hasOwnProperty() is the older equivalent.

144. What is the difference between Array.filter() and Array.some()?
Array.filter() returns all elements that satisfy a condition, while Array.some() checks if at least one element satisfies the condition.

145. What is the difference between Array.every() and Array.some()?
Array.every() checks if all elements satisfy a condition, while Array.some() checks if at least one element satisfies the condition.

146. What is the difference between Object.isFrozen() and Object.isSealed()?
Object.isFrozen() checks if an object is immutable, while Object.isSealed() checks if an object is sealed (no new properties can be added).

147. What is the difference between Object.entries() and Object.values()?
Object.entries() returns an array of key-value pairs, while Object.values() returns an array of values.

148. What is the difference between Array.slice() and Array.splice()?
Array.slice() creates a shallow copy of a portion of the array, while Array.splice() modifies the original array by adding or removing elements.

149. What is the difference between Object.create() and class inheritance?
Object.create() creates an object with a specified prototype, while class inheritance uses the class keyword to define a blueprint for creating objects.

150. What are design patterns in JavaScript?
Design patterns are reusable solutions to common software design problems. Examples include Singleton, Module, Observer, Factory, Prototype, Decorator, and Command patterns. They help structure code efficiently and solve problems in a reusable way.

151. What is the difference between Object.freeze() and Object.seal()?
Object.freeze() makes an object completely immutable, meaning you cannot add, remove, or modify properties. Object.seal() prevents adding or removing properties but allows modifying existing ones.

152. What is the difference between Array.map() and Array.forEach()?
Array.map() creates a new array by applying a function to each element, while Array.forEach() simply iterates over the array without returning anything.

153. What is the difference between Array.filter() and Array.find()?
Array.filter() returns all elements that satisfy a condition as a new array, while Array.find() returns only the first element that satisfies the condition.

154. What is the difference between Array.some() and Array.every()?
Array.some() checks if at least one element satisfies a condition, while Array.every() checks if all elements satisfy the condition.

155. What is the difference between Object.keys() and Object.entries()?
Object.keys() returns an array of the object's keys, while Object.entries() returns an array of key-value pairs.

156. What is the difference between Object.create() and Object.assign()?
Object.create() creates a new object with a specified prototype, while Object.assign() copies properties from one or more source objects to a target object.

157. What is the difference between Object.getPrototypeOf() and Object.setPrototypeOf()?
Object.getPrototypeOf() retrieves the prototype of an object, while Object.setPrototypeOf() sets the prototype of an object.

158. What is the difference between Object.defineProperty() and Object.defineProperties()?
Object.defineProperty() defines a single property on an object, while Object.defineProperties() defines multiple properties at once.

159. What is the difference between Object.is() and ===?
Object.is() is similar to === but treats NaN as equal to NaN and +0 as not equal to -0.

160. What is the difference between Array.reduce() and Array.reduceRight()?
Array.reduce() processes elements from left to right, while Array.reduceRight() processes elements from right to left.

161. What is the difference between Array.concat() and the spread operator?
Both combine arrays, but Array.concat() is a method, while the spread operator (...) is a syntax feature.

162. What is the difference between Array.fill() and Array.from()?
Array.fill() fills an array with a static value, while Array.from() creates a new array from an iterable or array-like object.

163. What is the difference between Array.keys(), Array.values(), and Array.entries()?
Array.keys() returns an iterator for the array's keys, Array.values() returns an iterator for the values, and Array.entries() returns an iterator for key-value pairs.

164. What is the difference between Function.prototype.call() and Function.prototype.apply()?
Both invoke a function with a specific this context, but call() takes arguments individually, while apply() takes arguments as an array.

165. What is the difference between Object.freeze() and Object.preventExtensions()?
Object.freeze() makes an object immutable, while Object.preventExtensions() only prevents adding new properties.

166. What is the difference between Array.findIndex() and Array.indexOf()?
Array.findIndex() returns the index of the first element that satisfies a condition, while Array.indexOf() returns the index of a specific value.

167. What are design patterns in JavaScript?
Design patterns are reusable solutions to common software design problems. Examples include Singleton, Module, Observer, Factory, Prototype, Decorator, and Command patterns. They help structure code efficiently and solve problems in a reusable way.


