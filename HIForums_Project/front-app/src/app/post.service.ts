import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from './post';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseURL = "http://localhost:8080/api/posts";


  constructor(private httpClient: HttpClient) { }

  //Get All Posts
  getPostsList(): Observable<Post[]>{
    return this.httpClient.get<Post[]>(`${this.baseURL}`);
  }

  //Create Post
  createPost(Post: Post): Observable<Post>{
    return this.httpClient.post<Post>(`${this.baseURL}`,Post);
  }

  //Get Post by id
  getPostById(id: number): Observable<Post>{
    return this.httpClient.get<Post>(`${this.baseURL}/${id}`);
  }

  //UPDATE Post
  updatePost(id: number, post: Post): Observable<Post>{
    return this.httpClient.put<Post>(`${this.baseURL}/${id}`, post);
  }

  //delete Post
  deletePost(id: number): Observable<Post>{
    return this.httpClient.delete<Post>(`${this.baseURL}/${id}`);
  }
}
