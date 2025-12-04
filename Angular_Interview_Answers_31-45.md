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