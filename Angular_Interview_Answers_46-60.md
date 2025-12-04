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