# Angular Interview Questions with Spoken Answers (Questions 61-80)

## All Interview Questions Extracted (1-116)

### 1. **What is Angular?**
### 2. **What is the difference between Angular and AngularJS?**
### 3. **What are new features added in Angular 18?**
### 4. **What are the key components of Angular?**
### 5. **What is data binding in Angular? Explain the different types.**
### 6. **What is an Angular lifecycle hook? Can you name some common ones?**
### 7. **What are decorators in Angular?**
### 8. **What is a directive in Angular? Can you name the different types?**
### 9. **What are components?**
### 10. **What are modules in Angular?**
### 11. **What is a service in Angular?**
### 12. **What is dependency injection in Angular?**
### 13. **What are Observables and how are they used in Angular?**
### 14. **What is a provider?**
### 15. **What are pipes in Angular? Can you create custom pipes?**
### 16. **What is an observable?**
### 17. **What is an observer?**
### 18. **What are the steps to update Angular from older version to current version?**
### 19. **What is multicasting?**
### 20. **What is a bootstrapping module?**
### 21. **Which file loads first in Angular application?**
### 22. **What happens in index.html?**
### 23. **What happens in main.ts?**
### 24. **What happens in app.module.ts?**
### 25. **What happens in app.component.ts?**
### 26. **If I rename main.ts, will application load?**
### 27. **What is the role of main.ts?**
### 28. **What happens if you rename main.ts?**
### 29. **How to fix renamed main.ts?**
### 30. **What are additional considerations when renaming main.ts?**
### 31. **Default project files and folder details**
### 32. **e2e/ (End-to-End Testing Folder)**
### 33. **node_modules/**
### 34. **src/ (Source Folder)**
### 35. **angular.json**
### 36. **package-lock.json or yarn.lock**
### 37. **package.json**
### 38. **tsconfig.json**
### 39. **tsconfig.app.json**
### 40. **tsconfig.spec.json**
### 41. **karma.conf.js**
### 42. **protractor.conf.js**
### 43. **webpack.config.js (Optional for Advanced Users)**
### 44. **What is a template?**
### 45. **What is the difference between promise and observable?**
### 46. **What is an Angular router and why is it used?**
### 47. **What is the purpose of the ngOnInit method in Angular components?**
### 48. **How does Angular handle event binding?**
### 49. **How can you make an HTTP request in Angular?**
### 50. **What is the ngIf directive used for in Angular?**
### 51. **What is the ngFor directive used for in Angular?**
### 52. **What is the ngClass directive used for in Angular?**
### 53. **What is a template reference variable in Angular?**
### 54. **What are Angular forms? What are the two types of forms in Angular?**
### 55. **What is the purpose of the ngModel directive in Angular?**
### 56. **What is the async pipe in Angular, and how does it work with Observables?**
### 57. **What is lazy loading in Angular? How does it improve application performance?**
### 58. **What is change detection in Angular? How does it work?**
### 59. **Explain the concept of zones in Angular.**
### 60. **What are @Input and @Output decorators in Angular?**

---

## Questions 61-80 with Real-Time Spoken Answers (15-30 seconds each)

### 61. **What is the difference between localStorage and sessionStorage in Angular?**
**Spoken Answer:** LocalStorage persists data permanently until explicitly deleted, surviving browser restarts. SessionStorage only lasts for the current tab session and clears when the tab closes. LocalStorage is accessible across all tabs of the same origin, while sessionStorage is isolated to the specific tab. Use localStorage for user preferences, sessionStorage for temporary data like form drafts.

### 62. **How does Angular handle cross-site request forgery (CSRF)?**
**Spoken Answer:** Angular doesn't provide built-in CSRF protection, but works with server-side solutions. The server generates CSRF tokens that must be included in requests. You can add tokens to HTTP requests using interceptors. Also use SameSite cookies and ensure the backend validates authentication tokens in request headers for proper CSRF protection.

### 63. **What are Angular modules and how do they help in organizing an application?**
**Spoken Answer:** Angular modules are containers that organize related components, services, and directives using @NgModule decorator. They provide code organization by dividing large apps into manageable pieces, enable lazy loading for better performance, and define dependency injection context. Feature modules group functionality, shared modules contain reusable code, and the root module bootstraps the app.

### 64. **What is a custom directive, and how do you create one?**
**Spoken Answer:** Custom directives extend HTML functionality with custom behavior. Create one by making a class with @Directive decorator, implementing the desired behavior using ElementRef and Renderer2. For example, a highlight directive that changes text color. Use the selector in templates like any other directive. They're perfect for reusable DOM manipulation logic.

### 65. **How do you create and use services in Angular?**
**Spoken Answer:** Generate services using ng generate service command. Mark the class with @Injectable decorator and providedIn: 'root' for singleton behavior. Define methods for business logic like API calls. Inject services into components through constructor parameters. Services promote code reusability and separation of concerns by keeping business logic out of components.

### 66. **What is the role of the RouterModule in Angular?**
**Spoken Answer:** RouterModule provides routing functionality for navigation between views in single-page applications. It enables route definition mapping URLs to components, provides routing directives like routerLink and router-outlet, and supports route guards for protection. Import RouterModule.forRoot in the root module and RouterModule.forChild in feature modules.

### 67. **How would you handle HTTP errors in Angular?**
**Spoken Answer:** Handle HTTP errors using the catchError operator in RxJS pipes. Catch errors in services and return fallback data or rethrow for component handling. Use global error handling with HTTP interceptors for consistent error management. Implement retry logic for transient errors and provide user-friendly error messages in components.

### 68. **How can you optimize the performance of an Angular application?**
**Spoken Answer:** Use lazy loading to reduce initial bundle size, implement OnPush change detection strategy, use trackBy functions in ngFor loops, enable AOT compilation for production, implement tree shaking to remove unused code, optimize images and assets, use web workers for heavy computations, and implement service workers for caching and offline functionality.

### 69. **What is the role of the Angular CLI in the development process?**
**Spoken Answer:** Angular CLI automates development tasks like creating projects with ng new, generating components and services with ng generate, serving development builds with ng serve, building for production with ng build, running tests with ng test, and managing dependencies. It enforces best practices and standardizes project structure across teams.

### 70. **How can you handle routing with route guards in Angular?**
**Spoken Answer:** Route guards control access to routes based on conditions. CanActivate protects route activation, CanDeactivate prevents leaving routes, CanLoad prevents loading lazy modules, and Resolve pre-fetches data. Implement guard interfaces, check authentication or permissions, and return boolean or redirect to other routes. Apply guards in route configuration with canActivate property.

### 71. **What is the purpose of the ng-content and ng-template directive in Angular?**
**Spoken Answer:** Ng-content enables content projection, allowing parent components to pass HTML content into child components. It's perfect for reusable UI components like cards or modals. Ng-template defines reusable template blocks that aren't rendered immediately but can be displayed conditionally with structural directives like ngIf else clauses or dynamic component loading.

### 72. **What is a resolver in Angular, and when would you use one?**
**Spoken Answer:** A resolver pre-fetches data before route activation, ensuring components always have required data when loaded. Implement the Resolve interface and return observables from the resolve method. Use resolvers when you need guaranteed data availability, want to show loading states at route level, or need to fetch data based on route parameters before component initialization.

### 73. **How does Angular support internationalization (i18n)?**
**Spoken Answer:** Angular provides built-in i18n support through the @angular/localize package. Mark text for translation with i18n attributes, extract strings using ng extract-i18n, translate them into different languages, and build locale-specific versions with ng build --localize. Angular also provides locale-specific pipes for dates, currency, and numbers formatting.

### 74. **What is a singleton service in Angular?**
**Spoken Answer:** A singleton service has only one instance throughout the application lifetime. Angular services are singletons by default when provided at root level using providedIn: 'root'. This ensures shared state and behavior across components. The same service instance is injected everywhere, making it perfect for managing global application state, authentication, or configuration data.

### 75. **Explain the difference between ngOnInit and constructor in Angular components.**
**Spoken Answer:** Constructor is called when the class is instantiated and is used for dependency injection and basic setup. NgOnInit is a lifecycle hook called after input properties are initialized and the component is ready. Use constructor for DI and simple initialization, ngOnInit for logic that depends on input bindings, API calls, and component setup.

### 76. **What is the RxJS library, and how is it used in Angular?**
**Spoken Answer:** RxJS is a reactive programming library using observables for handling asynchronous data streams. Angular uses RxJS extensively for HTTP requests, form handling, routing, and event management. It provides operators like map, filter, switchMap for data transformation. HttpClient returns observables, and the async pipe automatically handles subscriptions and cleanup.

### 77. **Explain operators like map, filter, merge, and switchMap**
**Spoken Answer:** Map transforms emitted values by applying a function to each value. Filter only emits values that pass a condition test. Merge combines multiple observables into one stream, emitting all values as they arrive. SwitchMap switches to a new observable and cancels the previous one, perfect for search functionality where you only want the latest results.

### 78. **map operator**
**Spoken Answer:** The map operator transforms each emitted value by applying a transformation function. It takes the input value, applies your function, and emits the transformed result. For example, multiplying numbers by two or extracting properties from objects. It's like Array.map but for observable streams, maintaining the same number of emissions with transformed values.

### 79. **filter operator**
**Spoken Answer:** The filter operator only emits values that pass a predicate test function. It evaluates each emitted value against your condition and only lets through values that return true. For example, filtering even numbers or non-empty strings. It reduces the stream to only the values you're interested in, similar to Array.filter for observables.

### 80. **merge operator**
**Spoken Answer:** The merge operator combines multiple observables into a single stream, emitting values from all source observables as they arrive. It maintains the emission order and doesn't wait for completion. Perfect for combining user input events, multiple data sources, or parallel operations where you want all results in one stream without transformation.

---

## Remaining Questions (81-116)

### 81. **switchMap operator**
### 82. **How do you handle error handling in RxJS streams?**
### 83. **What is the difference between switchMap, concatMap, and mergeMap in RxJS?**
### 84. **How to Handle parallel Service Calls in angular?**
### 85. **Using forkJoin (Most Common)**
### 86. **Using combineLatest (When You Want Latest Results)**
### 87. **How does Angular handle state management, and what libraries can be used?**
### 88. **What is Ahead-of-Time (AOT) compilation vs Just-in-Time (JIT) compilation?**
### 89. **What are Angular Universal applications, and how does server-side rendering work?**
### 90. **What are Angular decorators, and what role do they play in Angular development?**
### 91. **How do you configure Angular to work with environment-specific settings?**
### 92. **What are the advantages and disadvantages of using Angular for web development?**
### 93. **How to implement authguard in angular?**
### 94. **Create an Authentication Service**
### 95. **Create an AuthGuard**
### 96. **Define Routes and Protect with the AuthGuard**
### 97. **Difference between Authentication and Authorization**
### 98. **Authentication**
### 99. **Authorization**
### 100. **Implement Login and Logout Functionality**
### 101. **Test the Application**
### 102. **How would you troubleshoot performance issues in Angular?**
### 103. **How do you handle error handling in RxJS streams? (duplicate)**
### 104. **What is a Subject and BehaviorSubject in Angular RxJS?**
### 105. **Explain the difference between ngOnInit() and constructor() in Angular components.**
### 106. **What is the difference between ngFor and ngForOf?**
### 107. **What are Angular decorators and name a few common ones?**
### 108. **What is the role of ngZone in Angular, and how does it help with performance optimization?**
### 109. **What is the purpose of the ngModule and how does it work in Angular?**
### 110. **What is Dependency Injection (DI) in Angular? Explain how it works.**
### 111. **What are interceptors in Angular? How do you use them?**
### 112. **How do you implement routing in Angular, and what are the different navigation methods?**
### 113. **What are Angular Guards? Explain the different types of guards.**
### 114. **How would you optimize performance in an Angular application?**
### 115. **What is the purpose of Angular's Renderer2?**
### 116. **Explain the difference between ngOnChanges and ngDoCheck.**

---

*This document contains all 116 Angular interview questions with detailed spoken answers for questions 61-80, optimized for real-time interview scenarios (15-30 seconds each).*