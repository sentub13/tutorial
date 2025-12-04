# Angular Interview Answers (Questions 1-15)

## 1. What is Angular?

Angular is a TypeScript-based web framework for building single-page applications. It's a complete platform with everything you need - routing, forms, HTTP client, and more.

```typescript
// Basic Angular component
@Component({
  selector: 'app-hello',
  template: '<h1>Hello {{name}}!</h1>'
})
export class HelloComponent {
  name = 'Angular';
}
```

## 2. What is the difference between Angular and AngularJS?

AngularJS is the old JavaScript framework, Angular is the modern TypeScript rewrite. Angular has better performance, mobile support, and uses components instead of controllers.

```typescript
// Angular (modern)
@Component({
  selector: 'app-user',
  template: '<p>{{user.name}}</p>'
})
export class UserComponent {
  user = { name: 'John' };
}
```

## 3. What are new features added in Angular 18?

Angular 18 introduced control flow syntax, material design 3 support, and improved hydration. The new @if and @for syntax replaces structural directives.

```html
<!-- New control flow syntax -->
@if (user) {
  <p>Welcome {{user.name}}</p>
} @else {
  <p>Please login</p>
}

@for (item of items; track item.id) {
  <div>{{item.name}}</div>
}
```

## 4. What are the key components of Angular?

The main building blocks are Components, Services, Modules, Directives, and Pipes. Components handle the UI, Services manage data and logic.

```typescript
// Component
@Component({
  selector: 'app-root',
  template: '<h1>My App</h1>'
})
export class AppComponent {}

// Service
@Injectable()
export class DataService {
  getData() { return ['item1', 'item2']; }
}
```

## 5. What is data binding in Angular? Explain the different types.

Data binding connects component data to the template. There are four types: interpolation, property binding, event binding, and two-way binding.

```html
<!-- Interpolation -->
<h1>{{title}}</h1>

<!-- Property binding -->
<img [src]="imageUrl">

<!-- Event binding -->
<button (click)="onClick()">Click me</button>

<!-- Two-way binding -->
<input [(ngModel)]="name">
```

## 6. What is an Angular lifecycle hook? Can you name some common ones?

Lifecycle hooks let you tap into component lifecycle events. Common ones are ngOnInit, ngOnDestroy, and ngOnChanges.

```typescript
export class MyComponent implements OnInit, OnDestroy {
  ngOnInit() {
    console.log('Component initialized');
  }
  
  ngOnDestroy() {
    console.log('Component destroyed');
  }
}
```

## 7. What are decorators in Angular?

Decorators are functions that add metadata to classes. They tell Angular how to process classes - like @Component, @Injectable, @Input.

```typescript
@Component({
  selector: 'app-user',
  template: '<p>{{name}}</p>'
})
export class UserComponent {
  @Input() name: string;
  @Output() clicked = new EventEmitter();
}
```

## 8. What is a directive in Angular? Can you name the different types?

Directives are classes that add behavior to elements. Three types: Components (with templates), Attribute directives (change appearance), and Structural directives (change DOM structure).

```typescript
// Attribute directive
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  @HostListener('mouseenter') onMouseEnter() {
    this.el.nativeElement.style.backgroundColor = 'yellow';
  }
}
```

## 9. What are components?

Components are the basic building blocks of Angular apps. They control a part of the screen called a view, combining HTML template with TypeScript logic.

```typescript
@Component({
  selector: 'app-product',
  template: `
    <div>
      <h2>{{product.name}}</h2>
      <p>Price: {{product.price}}</p>
    </div>
  `
})
export class ProductComponent {
  product = { name: 'Laptop', price: 999 };
}
```

## 10. What are modules in Angular?

Modules organize related components, directives, and services into cohesive blocks. Every app has at least one root module - AppModule.

```typescript
@NgModule({
  declarations: [AppComponent, UserComponent],
  imports: [BrowserModule, FormsModule],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule {}
```

## 11. What is a service in Angular?

Services are classes that handle data and business logic. They're shared across components and injected using dependency injection.

```typescript
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private users = ['John', 'Jane'];
  
  getUsers() {
    return this.users;
  }
  
  addUser(name: string) {
    this.users.push(name);
  }
}
```

## 12. What is dependency injection in Angular?

Dependency injection is a design pattern where Angular provides dependencies to classes instead of classes creating them. It makes testing easier and code more modular.

```typescript
@Component({
  selector: 'app-user-list'
})
export class UserListComponent {
  users: string[];
  
  constructor(private userService: UserService) {
    this.users = userService.getUsers();
  }
}
```

## 13. What are Observables and how are they used in Angular?

Observables handle asynchronous data streams. Angular uses them for HTTP requests, event handling, and reactive programming with RxJS.

```typescript
export class DataComponent {
  data$ = this.http.get<any[]>('/api/data');
  
  constructor(private http: HttpClient) {}
  
  loadData() {
    this.data$.subscribe(data => {
      console.log('Data loaded:', data);
    });
  }
}
```

## 14. What is a provider?

A provider tells Angular how to create and inject dependencies. It's configured in modules or components to make services available.

```typescript
@NgModule({
  providers: [
    UserService,
    { provide: API_URL, useValue: 'https://api.example.com' }
  ]
})
export class AppModule {}
```

## 15. What are pipes in Angular? Can you create custom pipes?

Pipes transform data in templates for display. Angular has built-in pipes like date, currency. You can create custom pipes for specific transformations.

```typescript
// Built-in pipes
// {{ user.birthday | date:'short' }}
// {{ product.price | currency:'USD' }}

// Custom pipe
@Pipe({ name: 'reverse' })
export class ReversePipe implements PipeTransform {
  transform(value: string): string {
    return value.split('').reverse().join('');
  }
}

// Usage: {{ 'hello' | reverse }} outputs 'olleh'
```
# Angular Interview Answers (Questions 16-30)

## 16. What is an observer?

An observer is an object that defines callback functions for handling Observable emissions. It has next, error, and complete methods to process data streams.

```typescript
const observer = {
  next: (data) => console.log('Data:', data),
  error: (err) => console.error('Error:', err),
  complete: () => console.log('Stream completed')
};

this.dataService.getData().subscribe(observer);
```

## 17. What are the steps to update Angular from older version to current version?

Use Angular Update Guide and ng update command. Check dependencies, update Angular CLI first, then core packages, and test thoroughly.

```bash
# Update Angular CLI globally
npm install -g @angular/cli@latest

# Update project
ng update @angular/core @angular/cli
ng update @angular/material
```

## 18. What is multicasting?

Multicasting allows multiple subscribers to share the same Observable execution. Use share() or shareReplay() operators to avoid duplicate HTTP calls.

```typescript
const shared$ = this.http.get('/api/data').pipe(
  shareReplay(1)
);

// Both subscriptions share the same HTTP request
shared$.subscribe(data => console.log('Sub 1:', data));
shared$.subscribe(data => console.log('Sub 2:', data));
```

## 19. What is a bootstrapping module?

The bootstrapping module is the root module that starts your Angular application. It's typically AppModule, defined in main.ts with platformBrowserDynamic().

```typescript
// main.ts
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';

platformBrowserDynamic().bootstrapModule(AppModule);
```

## 20. Which file loads first in Angular application?

The index.html file loads first. It contains the root component selector and loads the bundled JavaScript files that Angular CLI generates.

```html
<!-- index.html -->
<!doctype html>
<html>
<head><title>My App</title></head>
<body>
  <app-root></app-root>
</body>
</html>
```

## 21. What happens in index.html?

Index.html is the main HTML page that hosts your Angular app. It contains the app-root selector where Angular mounts the application and includes script tags for bundles.

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>MyApp</title>
  <base href="/">
</head>
<body>
  <app-root></app-root>
</body>
</html>
```

## 22. What happens in main.ts?

Main.ts is the entry point that bootstraps the Angular application. It imports the root module and starts the app using platformBrowserDynamic().

```typescript
// main.ts
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';

platformBrowserDynamic()
  .bootstrapModule(AppModule)
  .catch(err => console.error(err));
```

## 23. What happens in app.module.ts?

App.module.ts defines the root module that declares components, imports other modules, and configures providers. It tells Angular how to assemble the application.

```typescript
@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

## 24. What happens in app.component.ts?

App.component.ts is the root component that gets bootstrapped. It contains the main application logic and template, serving as the entry point for your component tree.

```typescript
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';
}
```

## 25. What is the role of main.ts?

Main.ts serves as the application entry point. It bootstraps the root module, enabling production mode if needed, and handles startup errors.

```typescript
import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule);
```

## 26. If I rename main.ts, will application load?

No, the application won't load because Angular CLI looks for main.ts by default. You need to update the angular.json configuration to point to the new filename.

```json
// angular.json
"build": {
  "builder": "@angular-devkit/build-angular:browser",
  "options": {
    "main": "src/my-main.ts"
  }
}
```

## 27. What happens if you rename main.ts?

The build will fail because the bundler can't find the entry point. You'll get an error like "Module not found: Error: Can't resolve './main'".

```bash
# Error output
ERROR in ./src/main.ts
Module not found: Error: Can't resolve './main' in '/src'
```

## 28. How to fix renamed main.ts?

Update the "main" property in angular.json to point to your new filename, then rebuild the application.

```json
// angular.json - update main property
"architect": {
  "build": {
    "options": {
      "main": "src/bootstrap.ts"
    }
  }
}
```

## 29. What are additional considerations when renaming main.ts?

Update test configuration, ensure imports are correct, update any build scripts, and verify that development and production builds both work with the new name.

```json
// Also update in angular.json test section
"test": {
  "options": {
    "main": "src/test.ts",
    "karmaConfig": "karma.conf.js"
  }
}
```

## 30. What is a template?

A template is the HTML view that defines how a component renders. It can include Angular directives, binding expressions, and template reference variables.

```typescript
@Component({
  selector: 'app-user',
  template: `
    <div>
      <h2>{{user.name}}</h2>
      <button (click)="edit()">Edit</button>
    </div>
  `
})
export class UserComponent {
  user = { name: 'John' };
  edit() { console.log('Editing user'); }
}
```

# Angular Interview Answers (Questions 31-45)

## 31. What is the difference between promise and observable?

Promises handle single async values and are eager. Observables handle multiple values over time, are lazy, and support operators like map and filter.

```typescript
// Promise - single value
const promise = fetch('/api/data').then(res => res.json());

// Observable - multiple values, lazy
const observable$ = this.http.get('/api/data').pipe(
  map(data => data.items)
);
```

## 32. What is an Angular router and why is it used?

Angular Router enables navigation between different views or components in single-page applications. It manages URL changes without full page reloads.

```typescript
// app-routing.module.ts
const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'users/:id', component: UserComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];
```

## 33. What is the purpose of the ngOnInit method in Angular components?

ngOnInit runs after component initialization and is perfect for setup logic like API calls. It's called once after the first ngOnChanges.

```typescript
export class UserComponent implements OnInit {
  users: User[] = [];
  
  ngOnInit() {
    this.userService.getUsers().subscribe(
      users => this.users = users
    );
  }
}
```

## 34. How does Angular handle event binding?

Event binding uses parentheses syntax to listen to DOM events. Angular passes the event object to your handler method automatically.

```html
<button (click)="onClick($event)">Click me</button>
<input (keyup.enter)="onEnter()" (blur)="onBlur()">
```

```typescript
onClick(event: Event) {
  console.log('Button clicked:', event.target);
}
```

## 35. How can you make an HTTP request in Angular?

Use HttpClient service to make HTTP requests. Import HttpClientModule and inject HttpClient into your service or component.

```typescript
constructor(private http: HttpClient) {}

getUsers() {
  return this.http.get<User[]>('/api/users');
}

createUser(user: User) {
  return this.http.post<User>('/api/users', user);
}
```

## 36. What is the ngIf directive used for in Angular?

ngIf conditionally adds or removes elements from the DOM based on a boolean expression. It's structural directive that controls element visibility.

```html
<div *ngIf="user">
  Welcome {{user.name}}!
</div>

<p *ngIf="users.length === 0">No users found</p>
<div *ngIf="loading; else content">Loading...</div>
```

## 37. What is the ngFor directive used for in Angular?

ngFor repeats elements for each item in a collection. It's essential for displaying lists and includes tracking for performance optimization.

```html
<ul>
  <li *ngFor="let user of users; trackBy: trackByUserId">
    {{user.name}} - {{user.email}}
  </li>
</ul>
```

```typescript
trackByUserId(index: number, user: User) {
  return user.id;
}
```

## 38. What is the ngClass directive used for in Angular?

ngClass dynamically applies CSS classes based on expressions. You can use objects, arrays, or strings to control styling conditionally.

```html
<div [ngClass]="{'active': isActive, 'disabled': !isEnabled}">
  Status indicator
</div>

<button [ngClass]="buttonClasses">Submit</button>
```

```typescript
buttonClasses = {
  'btn-primary': this.isPrimary,
  'btn-large': this.isLarge
};
```

## 39. What is a template reference variable in Angular?

Template reference variables create references to DOM elements or components in templates. Use # syntax to access them in the same template.

```html
<input #nameInput type="text">
<button (click)="greet(nameInput.value)">Greet</button>

<app-child #childComponent></app-child>
<button (click)="childComponent.doSomething()">Call Child</button>
```

## 40. What are Angular forms? What are the two types of forms in Angular?

Angular forms handle user input validation and submission. Two types: Template-driven forms (simpler) and Reactive forms (more control and validation).

```typescript
// Reactive Form
this.userForm = this.fb.group({
  name: ['', Validators.required],
  email: ['', [Validators.required, Validators.email]]
});
```

```html
<!-- Template-driven -->
<input [(ngModel)]="user.name" required #name="ngModel">
```

## 41. What is the purpose of the ngModel directive in Angular?

ngModel creates two-way data binding between form controls and component properties. It's essential for template-driven forms and input synchronization.

```html
<input [(ngModel)]="username" placeholder="Enter username">
<p>Hello {{username}}!</p>

<select [(ngModel)]="selectedCity">
  <option value="NYC">New York</option>
  <option value="LA">Los Angeles</option>
</select>
```

## 42. What is the async pipe in Angular, and how does it work with Observables?

The async pipe automatically subscribes to Observables and unsubscribes when component destroys. It handles async data without manual subscription management.

```html
<div *ngFor="let user of users$ | async">
  {{user.name}}
</div>

<p>{{ (userService.getCurrentUser() | async)?.name }}</p>
```

```typescript
users$ = this.userService.getUsers();
```

## 43. What is lazy loading in Angular? How does it improve application performance?

Lazy loading loads feature modules only when needed, reducing initial bundle size. It improves startup performance by splitting code into smaller chunks.

```typescript
// app-routing.module.ts
const routes: Routes = [
  {
    path: 'admin',
    loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule)
  }
];
```

## 44. What is change detection in Angular? How does it work?

Change detection checks for data changes and updates the DOM accordingly. Angular runs it automatically after events, promises, and timers using Zone.js.

```typescript
// Manual change detection
constructor(private cdr: ChangeDetectorRef) {}

updateData() {
  this.data = newData;
  this.cdr.detectChanges(); // Force check
}
```

## 45. Explain the concept of zones in Angular.

Zones patch async operations to trigger change detection automatically. Zone.js monitors setTimeout, promises, and events to know when to update the UI.

```typescript
// Running outside Angular zone
constructor(private ngZone: NgZone) {}

heavyComputation() {
  this.ngZone.runOutsideAngular(() => {
    // This won't trigger change detection
    setTimeout(() => console.log('Done'), 1000);
  });
}
```

# Angular Interview Answers (Questions 46-60)

## 46. What are @Input and @Output decorators in Angular?

@Input passes data from parent to child components. @Output emits events from child to parent using EventEmitter. They enable component communication.

```typescript
// Child component
export class ChildComponent {
  @Input() userName: string;
  @Output() userClicked = new EventEmitter<string>();
  
  onClick() {
    this.userClicked.emit(this.userName);
  }
}
```

```html
<!-- Parent template -->
<app-child [userName]="currentUser" (userClicked)="onUserClick($event)"></app-child>
```

## 47. What is the difference between localStorage and sessionStorage in Angular?

localStorage persists data until manually cleared. sessionStorage only lasts for the browser session. Both store key-value pairs as strings.

```typescript
// localStorage - persists across sessions
localStorage.setItem('user', JSON.stringify(user));
const user = JSON.parse(localStorage.getItem('user'));

// sessionStorage - cleared when tab closes
sessionStorage.setItem('token', authToken);
const token = sessionStorage.getItem('token');
```

## 48. How does Angular handle cross-site request forgery (CSRF)?

Angular's HttpClient automatically handles CSRF by reading XSRF tokens from cookies and adding them to request headers. Configure token names if needed.

```typescript
// HttpClientXsrfModule configuration
imports: [
  HttpClientXsrfModule.withOptions({
    cookieName: 'XSRF-TOKEN',
    headerName: 'X-XSRF-TOKEN'
  })
]
```

## 49. What is a custom directive, and how do you create one?

Custom directives add behavior to elements. Create them using @Directive decorator. Attribute directives modify appearance, structural directives modify DOM structure.

```typescript
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  constructor(private el: ElementRef) {}
  
  @HostListener('mouseenter') onMouseEnter() {
    this.el.nativeElement.style.backgroundColor = 'yellow';
  }
}
```

```html
<p appHighlight>This text will be highlighted on hover</p>
```

## 50. How do you create and use services in Angular?

Create services with @Injectable decorator and inject them into components. Services handle business logic and data operations.

```typescript
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private users: User[] = [];
  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users');
  }
}
```

```typescript
// Using in component
constructor(private userService: UserService) {}
```

## 51. What is the role of the RouterModule in Angular?

RouterModule configures navigation and routing in Angular apps. It provides router directives, services, and configuration for single-page application navigation.

```typescript
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

// Feature module
RouterModule.forChild(childRoutes)
```

## 52. How would you handle HTTP errors in Angular?

Use RxJS catchError operator to handle HTTP errors gracefully. You can retry requests, show user-friendly messages, or redirect users.

```typescript
getUsers() {
  return this.http.get<User[]>('/api/users').pipe(
    catchError(error => {
      console.error('Error loading users:', error);
      return of([]); // Return empty array as fallback
    })
  );
}
```

## 53. How can you optimize the performance of an Angular application?

Use OnPush change detection, lazy loading, trackBy functions, async pipe, and AOT compilation. Minimize bundle size and use service workers.

```typescript
@Component({
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class OptimizedComponent {
  trackByUserId(index: number, user: User) {
    return user.id;
  }
}
```

## 54. What is the role of the Angular CLI in the development process?

Angular CLI automates project setup, code generation, building, testing, and deployment. It provides commands like ng new, ng generate, ng build, and ng serve.

```bash
ng new my-app
ng generate component user-list
ng build --prod
ng test
ng serve --port 4200
```

## 55. How can you handle routing with route guards in Angular?

Route guards control navigation access. CanActivate prevents unauthorized access, CanDeactivate prevents leaving unsaved changes, and Resolve pre-loads data.

```typescript
@Injectable()
export class AuthGuard implements CanActivate {
  canActivate(): boolean {
    return this.authService.isLoggedIn();
  }
}
```

```typescript
// Route configuration
{ path: 'admin', component: AdminComponent, canActivate: [AuthGuard] }
```

## 56. What is the purpose of the ng-content and ng-template directive in Angular?

ng-content enables content projection for reusable components. ng-template defines template blocks that can be conditionally rendered or repeated.

```html
<!-- Parent component -->
<app-card>
  <h2>Card Title</h2>
  <p>Card content goes here</p>
</app-card>
```

```html
<!-- Card component template -->
<div class="card">
  <ng-content></ng-content>
</div>
```

## 57. What is a resolver in Angular, and when would you use one?

Resolvers pre-fetch data before route activation, ensuring components have required data immediately. Use them for critical data that components need on initialization.

```typescript
@Injectable()
export class UserResolver implements Resolve<User> {
  resolve(route: ActivatedRouteSnapshot): Observable<User> {
    return this.userService.getUser(route.params['id']);
  }
}
```

```typescript
{ path: 'user/:id', component: UserComponent, resolve: { user: UserResolver } }
```

## 58. How does Angular support internationalization (i18n)?

Angular i18n extracts text for translation, supports multiple locales, and builds separate bundles per language. Use i18n attribute and Angular CLI commands.

```html
<p i18n="@@welcome">Welcome to our app!</p>
<span i18n="@@user.count" i18n-title title="Total users">
  {users.length, plural, =0 {no users} =1 {one user} other {{{users.length}} users}}
</span>
```

```bash
ng extract-i18n
ng build --localize
```

## 59. What is a singleton service in Angular?

A singleton service has only one instance shared across the entire application. Services provided in root are singletons by default.

```typescript
@Injectable({
  providedIn: 'root' // Creates singleton
})
export class DataService {
  private data = new BehaviorSubject([]);
  
  getData() {
    return this.data.asObservable();
  }
}
```

## 60. Explain the difference between ngOnInit and constructor in Angular components.

Constructor initializes the class and injects dependencies. ngOnInit runs after Angular sets up data-bound properties and is ideal for initialization logic.

```typescript
export class UserComponent implements OnInit {
  @Input() userId: string;
  
  constructor(private userService: UserService) {
    // Dependency injection only
    console.log(this.userId); // undefined
  }
  
  ngOnInit() {
    // Input properties are available
    console.log(this.userId); // actual value
    this.loadUser();
  }
}
```

# Angular Interview Answers (Questions 61-75)

## 61. What is the RxJS library, and how is it used in Angular?

RxJS is a reactive programming library for handling asynchronous data streams. Angular uses it extensively for HTTP requests, event handling, and component communication.

```typescript
import { Observable, of } from 'rxjs';
import { map, filter } from 'rxjs/operators';

// Creating and using observables
const data$ = this.http.get('/api/users').pipe(
  map(users => users.filter(user => user.active))
);
```

## 62. Explain operators like map, filter, merge, and switchMap

Map transforms data, filter selects items, merge combines streams, and switchMap switches to new observables. They're essential for reactive programming.

```typescript
// Transform data
users$.pipe(map(user => user.name))

// Filter items
users$.pipe(filter(user => user.age > 18))

// Combine streams
merge(stream1$, stream2$)

// Switch to new observable
searchTerm$.pipe(switchMap(term => this.search(term)))
```

## 63. How do you handle error handling in RxJS streams?

Use catchError operator to handle errors gracefully. You can return fallback values, retry operations, or rethrow errors as needed.

```typescript
this.http.get('/api/users').pipe(
  catchError(error => {
    console.error('API Error:', error);
    return of([]); // Return empty array as fallback
  }),
  retry(3) // Retry up to 3 times
);
```

## 64. What is the difference between switchMap, concatMap, and mergeMap in RxJS?

SwitchMap cancels previous requests, concatMap waits for completion in order, mergeMap runs all concurrently. Choose based on your use case.

```typescript
// switchMap - cancels previous
searchTerm$.pipe(switchMap(term => this.search(term)))

// concatMap - maintains order
requests$.pipe(concatMap(req => this.process(req)))

// mergeMap - concurrent execution
files$.pipe(mergeMap(file => this.upload(file)))
```

## 65. How to Handle parallel Service Calls in angular?

Use forkJoin for parallel calls that must all complete, or combineLatest for ongoing streams. Both wait for all observables to emit.

```typescript
// Wait for all to complete
const parallel$ = forkJoin({
  users: this.userService.getUsers(),
  posts: this.postService.getPosts(),
  comments: this.commentService.getComments()
});

parallel$.subscribe(({users, posts, comments}) => {
  // All data loaded
});
```

## 66. How does Angular handle state management, and what libraries can be used?

Angular uses services for simple state. For complex apps, use NgRx (Redux pattern), Akita, or NGXS for centralized state management.

```typescript
// Simple service state
@Injectable()
export class StateService {
  private state$ = new BehaviorSubject(initialState);
  
  getState() { return this.state$.asObservable(); }
  updateState(newState) { this.state$.next(newState); }
}
```

## 67. What is Ahead-of-Time (AOT) compilation vs Just-in-Time (JIT) compilation?

AOT compiles templates during build time for better performance and security. JIT compiles in the browser at runtime. Angular uses AOT by default.

```bash
# AOT compilation (default)
ng build --aot

# Development uses JIT-like compilation
ng serve
```

```typescript
// AOT catches template errors at build time
// JIT catches them at runtime
```

## 68. What are Angular Universal applications, and how does server-side rendering work?

Angular Universal enables server-side rendering for better SEO and faster initial page loads. It renders Angular apps on the server before sending to browsers.

```bash
ng add @nguniversal/express-engine
npm run build:ssr
npm run serve:ssr
```

```typescript
// Platform-specific code
import { isPlatformBrowser } from '@angular/common';

if (isPlatformBrowser(this.platformId)) {
  // Browser-only code
}
```

## 69. How do you configure Angular to work with environment-specific settings?

Use environment files for different configurations. Angular CLI replaces environment.ts with environment.prod.ts during production builds.

```typescript
// environment.ts
export const environment = {
  production: false,
  apiUrl: 'http://localhost:3000'
};

// environment.prod.ts
export const environment = {
  production: true,
  apiUrl: 'https://api.myapp.com'
};
```

```typescript
// Usage in service
constructor() {
  this.apiUrl = environment.apiUrl;
}
```

## 70. What are the advantages and disadvantages of using Angular for web development?

Advantages: TypeScript, dependency injection, comprehensive framework, strong CLI. Disadvantages: steep learning curve, large bundle size, frequent updates.

```typescript
// Advantages: Strong typing
interface User {
  id: number;
  name: string;
}

// Comprehensive tooling
ng generate component user-list
```

## 71. How to implement authguard in angular?

Create a guard service implementing CanActivate interface. Check authentication status and redirect to login if needed.

```typescript
@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private auth: AuthService, private router: Router) {}
  
  canActivate(): boolean {
    if (this.auth.isLoggedIn()) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
}
```

## 72. Difference between Authentication and Authorization

Authentication verifies who you are (login). Authorization determines what you can access (permissions). Both are essential for security.

```typescript
// Authentication - verify identity
login(credentials) {
  return this.http.post('/auth/login', credentials);
}

// Authorization - check permissions
canAccess(resource: string): boolean {
  return this.user.permissions.includes(resource);
}
```

## 73. How would you troubleshoot performance issues in Angular?

Use Angular DevTools, Chrome DevTools, and Lighthouse. Check for unnecessary change detection, large bundles, and memory leaks.

```typescript
// Performance monitoring
import { ChangeDetectionStrategy } from '@angular/core';

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class OptimizedComponent {}

// Bundle analysis
ng build --stats-json
npx webpack-bundle-analyzer dist/stats.json
```

## 74. What is a Subject and BehaviorSubject in Angular RxJS?

Subject is a multicast observable that can emit values to multiple subscribers. BehaviorSubject stores the last value and emits it to new subscribers.

```typescript
// Subject - no initial value
const subject = new Subject<string>();
subject.next('Hello');

// BehaviorSubject - has initial value
const behaviorSubject = new BehaviorSubject<string>('Initial');
behaviorSubject.next('Updated');
```

## 75. What is the difference between ngFor and ngForOf?

There's no difference - ngForOf is the actual directive name, ngFor is just a shorthand. Both create template instances for each item in a collection.

```html
<!-- Both are identical -->
<div *ngFor="let item of items">{{item}}</div>
<div *ngForOf="let item of items">{{item}}</div>

<!-- Full syntax -->
<ng-template ngFor let-item [ngForOf]="items">
  <div>{{item}}</div>
</ng-template>
```

# Angular Interview Answers (Questions 76-82)

## 76. What is the role of ngZone in Angular, and how does it help with performance optimization?

NgZone manages change detection by patching async operations. You can run code outside Angular's zone to avoid unnecessary change detection cycles for performance-heavy operations.

```typescript
constructor(private ngZone: NgZone) {}

heavyComputation() {
  this.ngZone.runOutsideAngular(() => {
    // This won't trigger change detection
    setInterval(() => {
      this.updateChart(); // Heavy operation
    }, 100);
  });
}

updateUI() {
  this.ngZone.run(() => {
    // Manually trigger change detection when needed
    this.data = newData;
  });
}
```

## 77. What is the purpose of the ngModule and how does it work in Angular?

NgModule organizes related components, directives, pipes, and services into cohesive blocks. It defines compilation context and provides dependency injection configuration.

```typescript
@NgModule({
  declarations: [AppComponent, UserComponent], // Components, directives, pipes
  imports: [BrowserModule, HttpClientModule],  // Other modules
  providers: [UserService],                   // Services
  bootstrap: [AppComponent],                  // Root component
  exports: [UserComponent]                    // Available to other modules
})
export class AppModule {}
```

## 78. What are interceptors in Angular? How do you use them?

Interceptors intercept HTTP requests and responses to add headers, handle errors, or transform data. They're perfect for authentication tokens and global error handling.

```typescript
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authReq = req.clone({
      setHeaders: { Authorization: `Bearer ${this.getToken()}` }
    });
    return next.handle(authReq);
  }
}
```

```typescript
// Register in module
providers: [
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
]
```

## 79. How do you implement routing in Angular, and what are the different navigation methods?

Configure routes in RouterModule and use router.navigate(), routerLink directive, or router.navigateByUrl() for navigation. Each method serves different use cases.

```typescript
// Route configuration
const routes: Routes = [
  { path: 'users/:id', component: UserComponent },
  { path: 'home', component: HomeComponent }
];
```

```typescript
// Navigation methods
this.router.navigate(['/users', userId]);
this.router.navigateByUrl('/home');
```

```html
<!-- Template navigation -->
<a routerLink="/users/123">User Profile</a>
<button (click)="goHome()">Home</button>
```

## 80. What are Angular Guards? Explain the different types of guards.

Guards control route access and navigation. CanActivate protects routes, CanDeactivate prevents leaving, CanLoad controls lazy loading, and Resolve pre-fetches data.

```typescript
// CanActivate - protect route access
@Injectable()
export class AuthGuard implements CanActivate {
  canActivate(): boolean {
    return this.authService.isLoggedIn();
  }
}

// CanDeactivate - prevent leaving unsaved changes
export class UnsavedGuard implements CanDeactivate<EditComponent> {
  canDeactivate(component: EditComponent): boolean {
    return !component.hasUnsavedChanges();
  }
}
```

## 81. What is the purpose of Angular's Renderer2?

Renderer2 provides a safe way to manipulate DOM elements without directly accessing them. It's platform-agnostic and works with server-side rendering.

```typescript
constructor(private renderer: Renderer2, private el: ElementRef) {}

ngOnInit() {
  // Safe DOM manipulation
  this.renderer.setStyle(this.el.nativeElement, 'color', 'blue');
  this.renderer.addClass(this.el.nativeElement, 'highlight');
  
  const button = this.renderer.createElement('button');
  this.renderer.appendChild(this.el.nativeElement, button);
}
```

## 82. Explain the difference between ngOnChanges and ngDoCheck.

NgOnChanges runs when input properties change and receives a changes object. NgDoCheck runs on every change detection cycle for custom change detection logic.

```typescript
export class MyComponent implements OnChanges, DoCheck {
  @Input() user: User;
  
  ngOnChanges(changes: SimpleChanges) {
    // Only when @Input properties change
    if (changes['user']) {
      console.log('User changed:', changes['user'].currentValue);
    }
  }
  
  ngDoCheck() {
    // Runs on every change detection cycle
    // Use for custom change detection logic
    if (this.hasCustomChanges()) {
      this.updateView();
    }
  }
}
```

