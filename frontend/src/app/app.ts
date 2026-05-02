import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from './user.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html'
})
export class AppComponent implements OnInit {

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

  newUser = {
    name: '',
    age: null
  };

  addUser() {
    if (!this.newUser.name) return;

    this.userService.createUser(this.newUser).subscribe(() => {
      this.userService.getUsers().subscribe(data => {
        this.users = data;
      });

      this.newUser = { name: '', age: null };
    });
  }
}
