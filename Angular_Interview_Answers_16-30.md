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