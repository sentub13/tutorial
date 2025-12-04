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