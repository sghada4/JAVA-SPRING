import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Theme } from './theme';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private baseURL = "http://localhost:8080/api/themes";

  constructor(private httpClient: HttpClient) { }

  //Get All themes
  getThemesList(): Observable<Theme[]>{
    return this.httpClient.get<Theme[]>(`${this.baseURL}`);
  }

  //Create Theme
  createTheme(theme: Theme): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,theme);
  }

  //Get theme by id
  getThemeById(id: number): Observable<Theme>{
    return this.httpClient.get<Theme>(`${this.baseURL}/${id}`);
  }

  //UPDATE THEME
  updateTheme(id: number, theme: Theme): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, theme);
  }

  //delete Theme
  deleteTheme(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
