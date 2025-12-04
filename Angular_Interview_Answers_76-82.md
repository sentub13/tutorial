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