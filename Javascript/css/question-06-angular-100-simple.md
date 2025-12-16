# Angular Interview Questions & Answers

## 8. What is a directive in Angular? Can you name the different types of directives?

**Answer:**
A directive is a class that adds behavior to elements in your Angular applications.

**Three types of directives:**
• **Component directives** - Directives with templates
• **Structural directives** - Change DOM layout (add/remove elements)
• **Attribute directives** - Change appearance or behavior

**Examples:**

```typescript
// Structural directive
<div *ngIf="isVisible">Show me</div>
<li *ngFor="let item of items">{{item}}</li>

// Attribute directive
<p [ngClass]="{'active': isActive}">Text</p>
<div [ngStyle]="{'color': textColor}">Styled text</div>

// Custom attribute directive
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  @HostListener('mouseenter') onMouseEnter() {
    this.el.nativeElement.style.backgroundColor = 'yellow';
  }
}
```

---

## 9. What are components?

**Answer:**
Components are the building blocks of Angular applications. They control a part of the screen called a view.

**Key features:**
• Has a TypeScript class with logic
• HTML template for the view
• CSS styles for appearance
• Decorator that defines metadata

**Example:**

```typescript
@Component({
  selector: 'app-user',
  template: `
    <h2>{{user.name}}</h2>
    <p>Age: {{user.age}}</p>
    <button (click)="updateAge()">Update Age</button>
  `,
  styles: [`
    h2 { color: blue; }
  `]
})
export class UserComponent {
  user = { name: 'John', age: 25 };
  
  updateAge() {
    this.user.age++;
  }
}
```

---

## 10. What are modules in Angular?

**Answer:**
Modules are containers that group related components, directives, pipes, and services together.

**Key points:**
• Every Angular app has at least one module (AppModule)
• Use @NgModule decorator
• Helps organize and lazy load features
• Defines compilation context

**Example:**

```typescript
@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }

// Feature module
@NgModule({
  declarations: [ProductComponent],
  imports: [CommonModule],
  exports: [ProductComponent]
})
export class ProductModule { }
```

---

## 11. What is a service in Angular?

**Answer:**
A service is a class that provides specific functionality that can be shared across components.

**Use cases:**
• Data fetching from APIs
• Business logic
• Shared state management
• Utility functions

**Example:**

```typescript
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private users: User[] = [];
  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users');
  }
  
  addUser(user: User): void {
    this.users.push(user);
  }
  
  getUserById(id: number): User {
    return this.users.find(u => u.id === id);
  }
}

// Using in component
export class UserComponent {
  users: User[] = [];
  
  constructor(private userService: UserService) {}
  
  ngOnInit() {
    this.userService.getUsers().subscribe(
      users => this.users = users
    );
  }
}
```

---

## 12. What is dependency injection in Angular?

**Answer:**
Dependency injection is a design pattern where dependencies are provided to a class rather than creating them inside the class.

**Benefits:**
• Loose coupling
• Easy testing with mocks
• Better code reusability
• Angular handles object creation

**Example:**

```typescript
// Service
@Injectable({
  providedIn: 'root'
})
export class DataService {
  getData() {
    return ['item1', 'item2'];
  }
}

// Component with DI
export class MyComponent {
  data: string[] = [];
  
  // Angular injects DataService automatically
  constructor(private dataService: DataService) {}
  
  ngOnInit() {
    this.data = this.dataService.getData();
  }
}

// Testing with mock
class MockDataService {
  getData() {
    return ['mock1', 'mock2'];
  }
}

// In test
TestBed.configureTestingModule({
  providers: [
    { provide: DataService, useClass: MockDataService }
  ]
});
```

---

## 13. What are Observables and how are they used in Angular?

**Answer:**
Observables are streams of data that you can subscribe to. They handle asynchronous operations and events.

**Key features:**
• Handle multiple values over time
• Lazy execution
• Cancellable
• Rich operators for data transformation

**Example:**

```typescript
// HTTP service returning Observable
@Injectable()
export class ApiService {
  constructor(private http: HttpClient) {}
  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users');
  }
}

// Component consuming Observable
export class UserComponent implements OnDestroy {
  users$ = this.apiService.getUsers();
  private destroy$ = new Subject<void>();
  
  constructor(private apiService: ApiService) {}
  
  ngOnInit() {
    // Subscribe with pipe
    this.users$.pipe(
      map(users => users.filter(u => u.active)),
      takeUntil(this.destroy$)
    ).subscribe(activeUsers => {
      console.log(activeUsers);
    });
  }
  
  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }
}

// Template with async pipe
// <div *ngFor="let user of users$ | async">{{user.name}}</div>
```

---

## 14. What is a provider?

**Answer:**
A provider tells Angular how to create and provide dependencies for dependency injection.

**Types of providers:**
• Class providers
• Value providers
• Factory providers
• Existing providers

**Example:**

```typescript
// Class provider (default)
providers: [UserService]
// Same as: { provide: UserService, useClass: UserService }

// Value provider
providers: [
  { provide: 'API_URL', useValue: 'https://api.example.com' }
]

// Factory provider
providers: [
  {
    provide: UserService,
    useFactory: (http: HttpClient) => new UserService(http),
    deps: [HttpClient]
  }
]

// Existing provider (alias)
providers: [
  { provide: NewService, useExisting: OldService }
]

// Using in component
constructor(
  private userService: UserService,
  @Inject('API_URL') private apiUrl: string
) {}
```

---

## 15. What are pipes in Angular? Can you create custom pipes?

**Answer:**
Pipes transform data in templates. They take input and return formatted output.

**Built-in pipes:**
• date, currency, uppercase, lowercase
• json, slice, async

**Custom pipes:**
• Use @Pipe decorator
• Implement PipeTransform interface

**Example:**

```typescript
// Using built-in pipes
// {{ user.name | uppercase }}
// {{ user.salary | currency:'USD' }}
// {{ user.birthDate | date:'shortDate' }}

// Custom pipe
@Pipe({
  name: 'truncate'
})
export class TruncatePipe implements PipeTransform {
  transform(value: string, limit: number = 10): string {
    if (!value) return '';
    return value.length > limit ? 
      value.substring(0, limit) + '...' : value;
  }
}

// Register in module
@NgModule({
  declarations: [TruncatePipe]
})

// Use in template
// {{ longText | truncate:20 }}

// Pure vs Impure pipes
@Pipe({
  name: 'filter',
  pure: false  // Impure pipe - runs on every change detection
})
export class FilterPipe implements PipeTransform {
  transform(items: any[], searchTerm: string): any[] {
    return items.filter(item => 
      item.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
  }
}
```

# Angular Interview Questions & Answers

## 16. What is an observable?

An observable is like a data stream that can emit multiple values over time. Think of it as a pipe where data flows through.

**Key Points:**
- Handles asynchronous data
- Can emit multiple values
- Lazy - only executes when subscribed
- Can be cancelled

```typescript
import { Observable } from 'rxjs';

// Creating an observable
const myObservable = new Observable(observer => {
  observer.next('Hello');
  observer.next('World');
  observer.complete();
});

// Using it
myObservable.subscribe(data => console.log(data));
```

## 17. What is an observer?

An observer is the consumer that listens to observable data. It's like having three callbacks ready to handle different situations.

**Key Points:**
- Has three methods: next(), error(), complete()
- Receives data from observables
- Handles success, error, and completion

```typescript
const observer = {
  next: (value) => console.log('Got value:', value),
  error: (err) => console.log('Error:', err),
  complete: () => console.log('Stream completed')
};

myObservable.subscribe(observer);
```

## 18. What is multicasting?

Multicasting allows one observable to share its execution with multiple subscribers. Instead of creating separate executions, everyone gets the same data.

**Key Points:**
- Shares single execution among multiple subscribers
- Uses subjects for implementation
- More efficient than multiple subscriptions

```typescript
import { Subject } from 'rxjs';

const subject = new Subject();

// Multiple subscribers share same execution
subject.subscribe(data => console.log('Subscriber 1:', data));
subject.subscribe(data => console.log('Subscriber 2:', data));

subject.next('Shared data'); // Both get same data
```

## 19. What is a bootstrapping module?

The bootstrapping module is the root module that starts your Angular application. It's like the main entry point that kicks everything off.

**Key Points:**
- Usually AppModule
- Contains bootstrap array with root component
- Loaded first when app starts

```typescript
@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent] // This component starts the app
})
export class AppModule { }
```

## 20. Which file loads first in Angular application?

The `main.ts` file loads first. It's the entry point that bootstraps your entire application.

**Key Points:**
- main.ts is the starting point
- Calls platformBrowserDynamic()
- Bootstraps the AppModule

```typescript
// main.ts
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';

platformBrowserDynamic()
  .bootstrapModule(AppModule)
  .catch(err => console.error(err));
```

## 21. If I rename `main.ts`, will application load?

No, the application won't load because Angular CLI looks for `main.ts` by default. You'd need to update the configuration.

**Key Points:**
- main.ts is configured in angular.json
- Must update "main" property if renamed
- Build process depends on this configuration

```json
// angular.json
"build": {
  "builder": "@angular-devkit/build-angular:browser",
  "options": {
    "main": "src/main.ts", // Change this if renamed
    "polyfills": "src/polyfills.ts"
  }
}
```

## 22. What is a template?

A template is the HTML view with Angular markup that defines how the component should be displayed. It's your component's face.

**Key Points:**
- HTML with Angular directives
- Uses data binding
- Can include pipes and expressions

```typescript
@Component({
  selector: 'app-user',
  template: `
    <h1>{{title}}</h1>
    <p *ngIf="showMessage">{{message}}</p>
    <button (click)="onClick()">Click me</button>
  `
})
export class UserComponent {
  title = 'Welcome';
  message = 'Hello World';
  showMessage = true;
  
  onClick() {
    this.showMessage = !this.showMessage;
  }
}
```

## 23. What is the difference between promise and observable?

Promises handle single async values, while observables handle streams of multiple values over time.

**Key Differences:**

| Promise | Observable |
|---------|------------|
| Single value | Multiple values |
| Eager execution | Lazy execution |
| Not cancellable | Cancellable |
| .then() | .subscribe() |

```typescript
// Promise - single value
const promise = new Promise(resolve => {
  setTimeout(() => resolve('Done'), 1000);
});
promise.then(data => console.log(data));

// Observable - multiple values
const observable = new Observable(observer => {
  let count = 0;
  setInterval(() => observer.next(count++), 1000);
});
const subscription = observable.subscribe(data => console.log(data));
// Can cancel: subscription.unsubscribe();
```

## 24. What is an Angular router and why is it used?

Angular Router enables navigation between different views/components in a single-page application. It's like having multiple pages without page refreshes.

**Key Points:**
- Manages navigation between components
- Updates URL without page reload
- Supports route guards and lazy loading
- Handles parameters and query strings

```typescript
// app-routing.module.ts
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'users/:id', component: UserComponent },
  { path: 'about', component: AboutComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

// Navigation in component
export class NavComponent {
  constructor(private router: Router) {}
  
  goToUser(id: number) {
    this.router.navigate(['/users', id]);
  }
}
```

```html
<!-- Template navigation -->
<nav>
  <a routerLink="/">Home</a>
  <a routerLink="/about">About</a>
</nav>
<router-outlet></router-outlet>
```

# Angular Interview Questions & Answers

## 25. What is the purpose of the `ngOnInit` method in Angular components?

**Answer:**
- `ngOnInit` is a lifecycle hook that runs after component initialization
- Perfect place for component setup logic and API calls
- Runs once after the first `ngOnChanges`

**Example:**
```typescript
export class UserComponent implements OnInit {
  users: User[] = [];

  ngOnInit() {
    this.loadUsers();
    this.setupFormValidation();
  }

  loadUsers() {
    this.userService.getUsers().subscribe(users => {
      this.users = users;
    });
  }
}
```

## 26. How does Angular handle event binding?

**Answer:**
- Use parentheses `()` to bind DOM events to component methods
- Angular listens for events and executes the bound method
- Can pass event object using `$event`

**Example:**
```typescript
// Component
export class ButtonComponent {
  handleClick(event: Event) {
    console.log('Button clicked!', event);
  }

  handleInput(value: string) {
    console.log('Input value:', value);
  }
}
```

```html
<!-- Template -->
<button (click)="handleClick($event)">Click Me</button>
<input (input)="handleInput($event.target.value)" />
<form (submit)="onSubmit($event)">Submit</form>
```

## 27. How can you make an HTTP request in Angular?

**Answer:**
- Use `HttpClient` service from `@angular/common/http`
- Import `HttpClientModule` in your module
- Inject `HttpClient` in your service or component

**Example:**
```typescript
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class DataService {
  constructor(private http: HttpClient) {}

  // GET request
  getUsers() {
    return this.http.get<User[]>('/api/users');
  }

  // POST request
  createUser(user: User) {
    return this.http.post<User>('/api/users', user);
  }

  // PUT request
  updateUser(id: number, user: User) {
    return this.http.put<User>(`/api/users/${id}`, user);
  }
}
```

```typescript
// In component
export class UserComponent {
  constructor(private dataService: DataService) {}

  loadUsers() {
    this.dataService.getUsers().subscribe({
      next: users => this.users = users,
      error: err => console.error(err)
    });
  }
}
```

## 28. What is the `ngIf` directive used for in Angular?

**Answer:**
- Conditionally adds or removes elements from the DOM
- Takes a boolean expression
- Element is completely removed when condition is false

**Example:**
```html
<!-- Basic usage -->
<div *ngIf="isLoggedIn">Welcome back!</div>

<!-- With else condition -->
<div *ngIf="users.length > 0; else noUsers">
  <p>Found {{users.length}} users</p>
</div>
<ng-template #noUsers>
  <p>No users found</p>
</ng-template>

<!-- With async pipe -->
<div *ngIf="user$ | async as user">
  Hello, {{user.name}}!
</div>
```

```typescript
export class AppComponent {
  isLoggedIn = true;
  users: User[] = [];
  user$ = this.userService.getCurrentUser();
}
```

## 29. What is the `ngFor` directive used for in Angular?

**Answer:**
- Repeats a template for each item in a collection
- Creates a new element for each item
- Provides local variables like `index`, `first`, `last`

**Example:**
```html
<!-- Basic loop -->
<ul>
  <li *ngFor="let user of users">{{user.name}}</li>
</ul>

<!-- With index and tracking -->
<div *ngFor="let item of items; let i = index; trackBy: trackByFn">
  {{i + 1}}. {{item.title}}
</div>

<!-- With additional variables -->
<div *ngFor="let user of users; let first = first; let last = last">
  <span [class.highlight]="first">{{user.name}}</span>
  <hr *ngIf="!last">
</div>
```

```typescript
export class ListComponent {
  users = [
    { id: 1, name: 'John' },
    { id: 2, name: 'Jane' }
  ];

  trackByFn(index: number, item: any) {
    return item.id;
  }
}
```

## 30. What is the `ngClass` directive used for in Angular?

**Answer:**
- Dynamically adds or removes CSS classes
- Accepts string, array, or object expressions
- Great for conditional styling

**Example:**
```html
<!-- String binding -->
<div [ngClass]="currentClass">Content</div>

<!-- Object binding -->
<div [ngClass]="{
  'active': isActive,
  'disabled': !isEnabled,
  'highlight': score > 80
}">Status</div>

<!-- Array binding -->
<div [ngClass]="['btn', 'btn-primary', extraClass]">Button</div>

<!-- Method binding -->
<div [ngClass]="getClasses()">Dynamic</div>
```

```typescript
export class StyleComponent {
  currentClass = 'featured';
  isActive = true;
  isEnabled = false;
  score = 85;
  extraClass = 'large';

  getClasses() {
    return {
      'success': this.score >= 70,
      'warning': this.score >= 50 && this.score < 70,
      'danger': this.score < 50
    };
  }
}
```

## 31. What is a template reference variable in Angular?

**Answer:**
- Variables that reference DOM elements or Angular components
- Created using `#variableName` syntax
- Accessible within the template scope

**Example:**
```html
<!-- Reference to input element -->
<input #userInput type="text" />
<button (click)="processInput(userInput.value)">Submit</button>

<!-- Reference to component -->
<app-child #childComponent></app-child>
<button (click)="childComponent.reset()">Reset Child</button>

<!-- Reference in ngFor -->
<div *ngFor="let item of items">
  <input #itemInput [value]="item.name" />
  <button (click)="updateItem(item.id, itemInput.value)">Update</button>
</div>

<!-- Reference with ngModel -->
<input #phone ngModel placeholder="Phone number" />
<p>{{phone.value}}</p>
<p *ngIf="phone.invalid && phone.touched">Invalid phone number</p>
```

```typescript
export class FormComponent {
  processInput(value: string) {
    console.log('Input value:', value);
  }

  updateItem(id: number, newValue: string) {
    // Update logic here
  }
}
```

# Intermediate Angular Interview Questions & Answers

## 32. What are Angular forms? What are the two types of forms in Angular?

**Angular forms** handle user input and validation in web applications.

**Two types:**
• **Template-driven forms** - Uses directives in template
• **Reactive forms** - Uses FormControl and FormGroup in component

```typescript
// Template-driven
<form #userForm="ngForm">
  <input name="email" ngModel required>
</form>

// Reactive
export class MyComponent {
  userForm = new FormGroup({
    email: new FormControl('', Validators.required)
  });
}
```

---

## 33. What is the purpose of the `ngModel` directive in Angular?

**ngModel** creates two-way data binding between form controls and component properties.

• Binds input values to component data
• Updates UI when data changes
• Provides form validation states

```typescript
export class Component {
  username = '';
}
```

```html
<input [(ngModel)]="username" name="username">
<p>Hello {{username}}</p>
```

---

## 34. What is the `async` pipe in Angular, and how does it work with Observables?

**Async pipe** automatically subscribes to Observables and unsubscribes when component destroys.

• Handles subscription lifecycle
• Updates view when Observable emits
• Prevents memory leaks

```typescript
export class Component {
  users$ = this.http.get<User[]>('/api/users');
}
```

```html
<div *ngFor="let user of users$ | async">
  {{user.name}}
</div>
```

---

## 35. What is lazy loading in Angular? How does it improve application performance?

**Lazy loading** loads feature modules only when needed, not at startup.

**Performance benefits:**
• Reduces initial bundle size
• Faster app startup
• Better user experience

```typescript
// app-routing.module.ts
const routes: Routes = [
  {
    path: 'products',
    loadChildren: () => import('./products/products.module').then(m => m.ProductsModule)
  }
];
```

---

## 36. What is change detection in Angular? How does it work?

**Change detection** checks if component data changed and updates the DOM accordingly.

**How it works:**
• Runs after events (click, HTTP, timers)
• Compares current vs previous values
• Updates DOM if changes found

```typescript
export class Component {
  count = 0;
  
  increment() {
    this.count++; // Triggers change detection
  }
}
```

```html
<button (click)="increment()">Count: {{count}}</button>
```

---

## 37. Explain the concept of zones in Angular.

**Zone.js** patches browser APIs to detect asynchronous operations and trigger change detection.

• Monitors async operations
• Automatically runs change detection
• Handles promises, events, timers

```typescript
// Zone automatically detects this
setTimeout(() => {
  this.message = 'Updated'; // Change detection runs
}, 1000);

// Outside zone - no detection
this.ngZone.runOutsideAngular(() => {
  setTimeout(() => {
    // Manual trigger needed
    this.ngZone.run(() => {
      this.message = 'Updated';
    });
  }, 1000);
});
```

---

## 38. What are `@Input` and `@Output` decorators in Angular?

**@Input** receives data from parent component
**@Output** sends data to parent component

```typescript
// Child Component
export class ChildComponent {
  @Input() title: string;
  @Output() clicked = new EventEmitter<string>();
  
  onClick() {
    this.clicked.emit('Button clicked!');
  }
}
```

```html
<!-- Parent Template -->
<app-child 
  [title]="parentTitle" 
  (clicked)="handleClick($event)">
</app-child>
```

```typescript
// Parent Component
export class ParentComponent {
  parentTitle = 'Hello Child';
  
  handleClick(message: string) {
    console.log(message);
  }
}
```

## 39. What is the difference between `localStorage` and `sessionStorage` in Angular?

**Answer:**
Both are browser storage APIs that Angular can use, but they differ in persistence:

• **localStorage** - Data persists until manually cleared
• **sessionStorage** - Data clears when browser tab closes
• Both store key-value pairs as strings
• Same API methods for both

```typescript
// localStorage - persists across sessions
localStorage.setItem('user', JSON.stringify({name: 'John'}));
const user = JSON.parse(localStorage.getItem('user'));

// sessionStorage - cleared on tab close
sessionStorage.setItem('token', 'abc123');
const token = sessionStorage.getItem('token');

// Angular service example
@Injectable()
export class StorageService {
  setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }
  
  getUser() {
    return JSON.parse(localStorage.getItem('user') || '{}');
  }
}
```

---

## 40. How does Angular handle cross-site request forgery (CSRF)?

**Answer:**
Angular provides built-in CSRF protection through interceptors:

• Uses **XSRF tokens** automatically
• Reads token from cookies
• Adds token to request headers
• Works with backend CSRF implementations

```typescript
// Automatic CSRF protection (default)
import { HttpClientXsrfModule } from '@angular/common/http';

@NgModule({
  imports: [
    HttpClientXsrfModule.withOptions({
      cookieName: 'XSRF-TOKEN',
      headerName: 'X-XSRF-TOKEN'
    })
  ]
})
export class AppModule {}

// Custom CSRF interceptor
@Injectable()
export class CsrfInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const token = this.getCSRFToken();
    const csrfReq = req.clone({
      setHeaders: { 'X-CSRF-TOKEN': token }
    });
    return next.handle(csrfReq);
  }
}
```

---

## 41. What are Angular modules and how do they help in organizing an application?

**Answer:**
Modules are containers that group related components, services, and features:

• **Root module** (AppModule) - bootstraps the app
• **Feature modules** - organize specific functionality
• **Shared modules** - contain reusable components
• **Core module** - singleton services

```typescript
// Feature module example
@NgModule({
  declarations: [
    UserListComponent,
    UserDetailComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  providers: [UserService]
})
export class UserModule {}

// Shared module
@NgModule({
  declarations: [LoaderComponent, ConfirmDialogComponent],
  imports: [CommonModule],
  exports: [LoaderComponent, ConfirmDialogComponent]
})
export class SharedModule {}

// Lazy loading with modules
const routes: Routes = [
  {
    path: 'users',
    loadChildren: () => import('./user/user.module').then(m => m.UserModule)
  }
];
```

---

## 42. What is a custom directive, and how do you create one?

**Answer:**
Custom directives extend HTML elements with custom behavior:

• **Attribute directives** - change element appearance/behavior
• **Structural directives** - modify DOM structure
• Use `@Directive` decorator
• Access element through `ElementRef`

```typescript
// Attribute directive - highlight text
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  constructor(private el: ElementRef) {}
  
  @Input() appHighlight: string = 'yellow';
  
  @HostListener('mouseenter') onMouseEnter() {
    this.el.nativeElement.style.backgroundColor = this.appHighlight;
  }
  
  @HostListener('mouseleave') onMouseLeave() {
    this.el.nativeElement.style.backgroundColor = '';
  }
}

// Usage in template
<p appHighlight="lightblue">Hover over me!</p>

// Structural directive - custom *ngIf
@Directive({
  selector: '[appUnless]'
})
export class UnlessDirective {
  @Input() set appUnless(condition: boolean) {
    if (!condition) {
      this.vcRef.createEmbeddedView(this.templateRef);
    } else {
      this.vcRef.clear();
    }
  }
  
  constructor(
    private templateRef: TemplateRef<any>,
    private vcRef: ViewContainerRef
  ) {}
}
```

---

## 43. How do you create and use services in Angular?

**Answer:**
Services handle business logic and data sharing between components:

• Use `@Injectable` decorator
• Provide in root or specific modules
• Inject using dependency injection
• Perfect for HTTP calls, data management

```typescript
// Create service
@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrl = 'https://api.example.com';
  
  constructor(private http: HttpClient) {}
  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/users`);
  }
  
  createUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/users`, user);
  }
}

// Use in component
@Component({
  selector: 'app-user-list',
  template: `
    <div *ngFor="let user of users">{{user.name}}</div>
  `
})
export class UserListComponent implements OnInit {
  users: User[] = [];
  
  constructor(private dataService: DataService) {}
  
  ngOnInit() {
    this.dataService.getUsers().subscribe(
      users => this.users = users
    );
  }
}
```

---

## 44. What is the role of the `RouterModule` in Angular?

**Answer:**
RouterModule enables navigation and routing in Angular applications:

• **forRoot()** - configures root routing
• **forChild()** - configures feature routing
• Handles URL mapping to components
• Supports guards, resolvers, lazy loading

```typescript
// App routing module
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'users/:id', component: UserDetailComponent },
  { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

// Feature routing
const userRoutes: Routes = [
  { path: '', component: UserListComponent },
  { path: 'new', component: UserFormComponent },
  { path: ':id/edit', component: UserFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(userRoutes)],
  exports: [RouterModule]
})
export class UserRoutingModule {}

// Navigation in component
constructor(private router: Router) {}

navigateToUser(id: number) {
  this.router.navigate(['/users', id]);
}
```

---

## 45. How would you handle HTTP errors in Angular?

**Answer:**
Handle HTTP errors using operators and interceptors:

• Use **catchError** operator with observables
• Create **error interceptors** for global handling
• Implement **retry logic** for failed requests
• Show user-friendly error messages

```typescript
// Service with error handling
@Injectable()
export class ApiService {
  constructor(private http: HttpClient) {}
  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users').pipe(
      retry(2),
      catchError(this.handleError)
    );
  }
  
  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'An error occurred';
    
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = error.error.message;
    } else {
      // Server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    
    return throwError(() => errorMessage);
  }
}

// Global error interceptor
@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  constructor(private snackBar: MatSnackBar) {}
  
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 401) {
          // Handle unauthorized
          this.router.navigate(['/login']);
        } else if (error.status >= 500) {
          // Handle server errors
          this.snackBar.open('Server error occurred', 'Close');
        }
        return throwError(() => error);
      })
    );
  }
}

// Component usage
export class UserComponent {
  users: User[] = [];
  errorMessage = '';
  
  loadUsers() {
    this.apiService.getUsers().subscribe({
      next: users => this.users = users,
      error: error => this.errorMessage = error
    });
  }
}
```

## 46. How can you optimize the performance of an Angular application?

**Answer:** There are several key strategies to optimize Angular performance:

• **OnPush Change Detection Strategy**
  - Reduces unnecessary change detection cycles
  - Only checks component when inputs change

```typescript
@Component({
  selector: 'app-user',
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `<div>{{user.name}}</div>`
})
export class UserComponent {
  @Input() user: User;
}
```

• **Lazy Loading Modules**
  - Load feature modules only when needed

```typescript
const routes: Routes = [
  {
    path: 'admin',
    loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule)
  }
];
```

• **TrackBy Functions**
  - Optimize *ngFor performance

```typescript
trackByUserId(index: number, user: User): number {
  return user.id;
}
```

```html
<div *ngFor="let user of users; trackBy: trackByUserId">
  {{user.name}}
</div>
```

• **Virtual Scrolling**
  - Handle large lists efficiently

```html
<cdk-virtual-scroll-viewport itemSize="50" class="viewport">
  <div *cdkVirtualFor="let item of items">{{item}}</div>
</cdk-virtual-scroll-viewport>
```

---

## 47. What is the role of the Angular CLI in the development process?

**Answer:** Angular CLI is the command-line interface that streamlines Angular development:

• **Project Setup**
  - Creates new projects with best practices

```bash
ng new my-app
ng generate component user-list
ng generate service user
```

• **Development Server**
  - Hot reload and live development

```bash
ng serve
ng serve --port 4200 --open
```

• **Build & Deployment**
  - Optimized production builds

```bash
ng build --prod
ng build --configuration=production
```

• **Testing**
  - Run unit and e2e tests

```bash
ng test
ng e2e
```

• **Code Generation**
  - Scaffolds components, services, modules

```bash
ng generate module feature --routing
ng generate guard auth
```

---

## 48. How can you handle routing with route guards in Angular?

**Answer:** Route guards control navigation and protect routes:

• **CanActivate Guard**
  - Controls if route can be activated

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

• **CanDeactivate Guard**
  - Prevents leaving unsaved changes

```typescript
@Injectable()
export class UnsavedChangesGuard implements CanDeactivate<FormComponent> {
  canDeactivate(component: FormComponent): boolean {
    if (component.hasUnsavedChanges()) {
      return confirm('You have unsaved changes. Do you want to leave?');
    }
    return true;
  }
}
```

• **Route Configuration**

```typescript
const routes: Routes = [
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard],
    canDeactivate: [UnsavedChangesGuard]
  }
];
```

---

## 49. What are interceptors in Angular? How would you use them for adding headers or logging API requests?

**Answer:** Interceptors intercept HTTP requests and responses globally:

• **Auth Header Interceptor**

```typescript
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('token');
    
    if (token) {
      const authReq = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${token}`)
      });
      return next.handle(authReq);
    }
    
    return next.handle(req);
  }
}
```

• **Logging Interceptor**

```typescript
@Injectable()
export class LoggingInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log('Request:', req.url, req.method);
    
    return next.handle(req).pipe(
      tap(event => {
        if (event instanceof HttpResponse) {
          console.log('Response:', event.status, event.body);
        }
      })
    );
  }
}
```

• **Provider Registration**

```typescript
@NgModule({
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ]
})
export class AppModule {}
```

---

## 50. What is the purpose of the `ng-content` and `ng-template` directive in Angular?

**Answer:** Both enable content projection and dynamic templates:

• **ng-content - Content Projection**
  - Projects content from parent to child component

```typescript
// Modal Component
@Component({
  selector: 'app-modal',
  template: `
    <div class="modal">
      <div class="header">
        <ng-content select="[slot=header]"></ng-content>
      </div>
      <div class="body">
        <ng-content></ng-content>
      </div>
    </div>
  `
})
export class ModalComponent {}
```

```html
<!-- Usage -->
<app-modal>
  <h2 slot="header">User Details</h2>
  <p>User information goes here</p>
</app-modal>
```

• **ng-template - Template Reference**
  - Defines reusable template blocks

```html
<div *ngIf="showUsers; else noUsers">
  <div *ngFor="let user of users">{{user.name}}</div>
</div>

<ng-template #noUsers>
  <p>No users found</p>
</ng-template>
```

• **Dynamic Template Usage**

```typescript
@Component({
  template: `
    <ng-container *ngTemplateOutlet="selectedTemplate"></ng-container>
    <ng-template #userTemplate>User View</ng-template>
    <ng-template #adminTemplate>Admin View</ng-template>
  `
})
export class DynamicComponent {
  @ViewChild('userTemplate') userTemplate: TemplateRef<any>;
  selectedTemplate: TemplateRef<any>;
}
```

---

## 51. What is a resolver in Angular, and when would you use one?

**Answer:** Resolvers pre-fetch data before route activation:

• **User Resolver**

```typescript
@Injectable()
export class UserResolver implements Resolve<User> {
  constructor(private userService: UserService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<User> {
    const userId = route.params['id'];
    
    return this.userService.getUser(userId).pipe(
      catchError(() => {
        this.router.navigate(['/users']);
        return EMPTY;
      })
    );
  }
}
```

• **Route Configuration**

```typescript
const routes: Routes = [
  {
    path: 'user/:id',
    component: UserDetailComponent,
    resolve: { user: UserResolver }
  }
];
```

• **Component Usage**

```typescript
@Component({
  template: `<div>{{user.name}}</div>`
})
export class UserDetailComponent implements OnInit {
  user: User;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.user = this.route.snapshot.data['user'];
  }
}
```

**When to use:**
- Pre-load critical data
- Prevent empty component states
- Handle data loading errors before navigation

---

## 52. How does Angular support internationalization (i18n)?

**Answer:** Angular provides built-in i18n support for multi-language applications:

• **Mark Text for Translation**

```html
<p i18n="@@welcome-message">Welcome to our app!</p>
<button i18n="button.save|Save button">Save</button>
```

• **Extract Messages**

```bash
ng extract-i18n
```

• **Translation Files**
  - Creates `messages.xlf` file

```xml
<trans-unit id="welcome-message">
  <source>Welcome to our app!</source>
  <target>¡Bienvenido a nuestra aplicación!</target>
</trans-unit>
```

• **Build Configuration**

```json
{
  "build": {
    "configurations": {
      "es": {
        "aot": true,
        "outputPath": "dist/es/",
        "i18nFile": "src/locale/messages.es.xlf",
        "i18nFormat": "xlf",
        "i18nLocale": "es"
      }
    }
  }
}
```

• **Build for Different Locales**

```bash
ng build --configuration=es
```

• **Pluralization**

```html
<span i18n>{count, plural, =0 {no items} =1 {one item} other {{{count}} items}}</span>
```

• **Date/Number Pipes with Locale**

```html
<p>{{today | date:'short'}}</p>
<p>{{price | currency}}</p>
```