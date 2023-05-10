import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Topic } from './topic';
import { Observable } from 'rxjs';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class TopicService {
  private baseURL = "http://localhost:8080/api/topics";


  constructor(private httpClient: HttpClient) { }

  //Get All topics
  getTopicsList(): Observable<Topic[]>{
    return this.httpClient.get<Topic[]>(`${this.baseURL}`);
  }

  //Create Topic
  createTopic(topic: Topic): Observable<Topic>{
    return this.httpClient.post<Topic>(`${this.baseURL}`,topic);
  }

  //Get topic by id
  getTopicById(id: number): Observable<Topic>{
    return this.httpClient.get<Topic>(`${this.baseURL}/${id}`);
  }

  //UPDATE Topic
  updateTopic(id: number, topic: Topic): Observable<Topic>{
    return this.httpClient.put<Topic>(`${this.baseURL}/${id}`, topic);
  }

  //delete Topic
  deleteTopic(id: number): Observable<Topic>{
    return this.httpClient.delete<Topic>(`${this.baseURL}/${id}`);
  }

  //Get posts topic by id
  getPostsTopicById(id: number): Observable<Post[]>{
    return this.httpClient.get<Post[]>(`${this.baseURL}/posts/${id}`);
  }
}
