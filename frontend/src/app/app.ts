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

    const payload = {
      name: this.newUser.name,
      age: this.newUser.age
    };

    this.userService.createUser(payload).subscribe((created: any) => {
      this.users = [...this.users, created];
      this.newUser = { name: '', age: null };
      this.editKey = null;
      console.log('UPDATED USERS after ADD:', this.users);
    });
  }

  deleteUser(key: string) {
    this.userService.deleteUser(key).subscribe(() => {
      this.users = this.users.filter(u => u.key !== key);
      console.log('UPDATED USERS after DELETE:', this.users);
    });
  }

  editKey: string | null = null;

  editUser(user: any) {
    this.newUser = { ...user };
    this.editKey = user.key;
  }

  saveUser() {
    this.userService.updateUser(this.editKey!, this.newUser)
      .subscribe(updated => {

        this.users = this.users.map(u =>
          u.key === this.editKey ? updated : u
        );

        this.cancelEdit();
      });
  }

  cancelEdit() {
    this.newUser = { name: '', age: null };
    this.editKey = null;
  }
}
