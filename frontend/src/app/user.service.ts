import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private api = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) {}

  getUsers() {
    return this.http.get<any[]>(this.api);
  }

  createUser(user: any) {
    return this.http.post<any>(`http://localhost:8080/api/users/create`, user);
  }

  deleteUser(key: string) {
    return this.http.delete(`http://localhost:8080/api/users/${key}`);
  }

  updateUser(key: string, user: any) {
    return this.http.put<any>(`http://localhost:8080/api/users/${key}`, user);
  }
}
