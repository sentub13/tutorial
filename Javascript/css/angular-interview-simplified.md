# Angular Interview Questions - Simplified for Real-Time

## Basic Questions

### 1. What is Angular?
Angular is a TypeScript-based framework for building single-page applications (SPAs). It provides:
- Component-based architecture
- Two-way data binding
- Dependency injection
- Built-in routing and forms

### 2. Angular vs AngularJS?
- **AngularJS (1.x)**: JavaScript-based, MVC pattern
- **Angular (2+)**: TypeScript-based, component architecture, better performance

### 3. Key Components of Angular?
- **Components**: Building blocks with template, class, and styles
- **Modules**: Organize app into cohesive blocks
- **Services**: Business logic and data sharing
- **Directives**: Extend HTML functionality
- **Pipes**: Transform data in templates

### 4. Data Binding Types?
- **Interpolation**: `{{ value }}`
- **Property Binding**: `[property]="value"`
- **Event Binding**: `(click)="method()"`
- **Two-way Binding**: `[(ngModel)]="value"`

### 5. Lifecycle Hooks?
- `ngOnInit()`: Component initialization
- `ngOnChanges()`: Input property changes
- `ngOnDestroy()`: Cleanup before destruction

## Intermediate Questions

### 6. What are Observables?
Observables handle asynchronous data streams. Used with:
- HTTP requests
- Event handling
- Real-time data updates

```typescript
this.http.get('api/data').subscribe(data => {
  console.log(data);
});
```

### 7. Angular Forms?
- **Template-driven**: Uses `ngModel`, good for simple forms
- **Reactive**: Uses `FormGroup`/`FormControl`, better for complex validation

### 8. What is Dependency Injection?
DI provides dependencies to classes instead of creating them internally:
```typescript
@Injectable({ providedIn: 'root' })
export class DataService { }
```

### 9. Angular Router?
Enables navigation between views:
```typescript
const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent }
];
```

### 10. Change Detection?
Angular automatically updates the view when data changes. Strategies:
- **Default**: Checks all components
- **OnPush**: Only checks when inputs change

## Advanced Questions

### 11. What is NgRx?
State management library for Angular applications:
- Centralized store
- Actions and reducers
- Effects for side effects

### 12. Lazy Loading?
Load modules only when needed:
```typescript
{
  path: 'feature',
  loadChildren: () => import('./feature/feature.module').then(m => m.FeatureModule)
}
```

### 13. Angular Universal?
Server-side rendering (SSR) for:
- Better SEO
- Faster initial load
- Improved performance

### 14. HTTP Interceptors?
Intercept HTTP requests/responses globally:
```typescript
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const authReq = req.clone({
      setHeaders: { Authorization: `Bearer ${token}` }
    });
    return next.handle(authReq);
  }
}
```

### 15. Route Guards?
Protect routes based on conditions:
- **CanActivate**: Can user access route?
- **CanDeactivate**: Can user leave route?

```typescript
@Injectable()
export class AuthGuard implements CanActivate {
  canActivate(): boolean {
    return this.authService.isAuthenticated();
  }
}
```

## Performance & Security

### 16. Performance Optimization?
- Use OnPush change detection
- Implement lazy loading
- Use trackBy in *ngFor
- Optimize bundle size
- Use virtual scrolling for large lists

### 17. Security Best Practices?
- Angular automatically prevents XSS
- Use HTTPS
- Implement CSRF protection
- Sanitize user input
- Keep dependencies updated

## Testing

### 18. Testing in Angular?
- **Unit Tests**: Jasmine + Karma
- **E2E Tests**: Protractor/Cypress
- **TestBed**: Configure testing environment

```typescript
beforeEach(() => {
  TestBed.configureTestingModule({
    declarations: [MyComponent],
    providers: [MyService]
  });
});
```

## Common Interview Scenarios

### 19. Component Communication?
- **Parent to Child**: `@Input()`
- **Child to Parent**: `@Output()` + `EventEmitter`
- **Unrelated Components**: Shared service with Subject

### 20. Error Handling?
```typescript
this.http.get('api/data').pipe(
  catchError(error => {
    console.error('Error:', error);
    return of([]);
  })
).subscribe();
```

### 21. Authentication Implementation?
```typescript
// Auth Service
login(credentials) {
  return this.http.post('/api/login', credentials)
    .pipe(tap(response => {
      localStorage.setItem('token', response.token);
    }));
}

// Auth Guard
canActivate(): boolean {
  return !!localStorage.getItem('token');
}
```

### 22. File Upload?
```typescript
uploadFile(file: File) {
  const formData = new FormData();
  formData.append('file', file);
  
  return this.http.post('/api/upload', formData, {
    reportProgress: true,
    observe: 'events'
  });
}
```

## Quick Tips for Interview

1. **Know the basics**: Components, services, modules
2. **Understand data flow**: How data moves between components
3. **Be familiar with RxJS**: Observables, operators
4. **Know testing basics**: TestBed, mocking
5. **Understand performance**: Change detection, lazy loading
6. **Security awareness**: XSS prevention, authentication
7. **Practice coding**: Be ready to write simple components/services

## Common Coding Questions

### Create a simple component:
```typescript
@Component({
  selector: 'app-user',
  template: `
    <div>
      <h2>{{user.name}}</h2>
      <p>{{user.email}}</p>
    </div>
  `
})
export class UserComponent {
  @Input() user: User;
}
```

### Create a service:
```typescript
@Injectable({ providedIn: 'root' })
export class UserService {
  constructor(private http: HttpClient) {}
  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users');
  }
}
```

### Use async pipe:
```html
<div *ngFor="let user of users$ | async">
  {{user.name}}
</div>
```

Remember: Focus on understanding concepts rather than memorizing syntax!