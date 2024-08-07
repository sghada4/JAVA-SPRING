import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = "http://localhost:8080/api";
  constructor(private httpClient: HttpClient) { }

  //Registration
  createUser(user: User): Observable<any>{
    return this.httpClient.post<User>(`${this.baseURL}/register`,user);
  }

    //Login
    login(user: User): Observable<any>{
      return this.httpClient.post<User>(`${this.baseURL}/login`,user);
    }
      //Get user by id
  getUserById(id: number): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/user/${id}`);
  }
}
