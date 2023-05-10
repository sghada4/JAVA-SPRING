import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Theme } from './theme';
import { Observable } from 'rxjs';
import { Topic } from './topic';

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
  createTheme(theme: Theme): Observable<Theme>{
    return this.httpClient.post<Theme>(`${this.baseURL}`,theme);
  }

  //Get theme by id
  getThemeById(id: number): Observable<Theme>{
    return this.httpClient.get<Theme>(`${this.baseURL}/${id}`);
  }

  //Get topics theme by id
  getTopicsThemeById(id: number): Observable<Topic[]>{
    return this.httpClient.get<Topic[]>(`${this.baseURL}/topics/${id}`);
  }

  //UPDATE THEME
  updateTheme(id: number, theme: Theme): Observable<Theme>{
    return this.httpClient.put<Theme>(`${this.baseURL}/${id}`, theme);
  }

  //delete Theme
  deleteTheme(id: number): Observable<Theme>{
    return this.httpClient.delete<Theme>(`${this.baseURL}/${id}`);
  }
}
