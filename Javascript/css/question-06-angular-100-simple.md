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