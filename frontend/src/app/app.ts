import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html'
})
export class AppComponent {

  users: any[] = [];

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.userService.getUsers().subscribe({
      next: (data) => {
        console.log('✅ USERS FROM API:', data);
        this.users = data;
      },
      error: (err) => {
        console.error('❌ HTTP ERROR:', err);
      }
    });
  }
}
