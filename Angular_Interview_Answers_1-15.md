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