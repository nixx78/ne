import { Component }          from '@angular/core';

@Component({
  selector: 'dashboard-ne',
  template: `
    <h1>{{title}}</h1>
    <nav>
      <a routerLink="/dashboard" routerLinkActive="active">Dashboard</a>
      <a routerLink="/post_message" routerLinkActive="active">Message gateway</a>
      <a routerLink="/message_browser" routerLinkActive="active">Message browser</a>
    </nav>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Notification engine';
}

