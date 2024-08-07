import { Component, OnInit } from '@angular/core';
import { SessionStorageService } from 'ngx-webstorage';
import { TopicService } from '../topic.service';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PostService } from '../post.service';
import { Post } from '../post';
import { Topic } from '../topic';
import { User } from '../user';
import { ThemeService } from '../theme.service';
import { Theme } from '../theme';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css'],
})
export class PostsComponent implements OnInit {
  post: Post = {
    id: 0,
    content: '',
    postPostedBy: null,
    postedIn: null,
  };
  userId = this.sessionStorage.retrieve('userId');
  topics: Topic[];
  posts: Post[];
  topic: Topic;
  id: number;
  user: User;
  themes: Theme[];
  
  constructor(
    private topicService: TopicService,
    private userService: UserService,
    private router: Router,
    private postService: PostService,
    private route: ActivatedRoute,
    private sessionStorage: SessionStorageService,
    private themeService: ThemeService
  ) {}
  ngOnInit(): void {
    this.getThemes();
    this.getLoggedUser();
    this.id = this.route.snapshot.params['id'];
    this.topic = new Topic();
    this.topicService.getPostsTopicById(this.id).subscribe(
      (data) => {
        this.posts = data;
      },
      (error) => {
        this.router.navigate([`/topic/${this.topic.id}`]);
        console.log(error);
      }
    );
    this.topicService.getTopicById(this.id).subscribe(
      (data) => {
        this.topic = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  private getThemes() {
    this.themeService.getThemesList().subscribe((data) => {
      this.themes = data;
    });
  }

  logout() {
    this.sessionStorage.clear();
  }

  savePost() {
    this.post.postPostedBy = this.user;
    this.post.postedIn = this.topic;
    // console.log(this.user);

    // const themeFormData = this.prepareFormData(this.theme)
    this.postService.createPost(this.post).subscribe(
      (response: Post) => {
        // console.log(response);
        // this.theme.topics.push(response);
        this.topicService.getPostsTopicById(this.id).subscribe(
          (data) => {
            this.posts = data;
          },
          (error) => {
            this.router.navigate([`/topic/${this.topic.id}`]);
            console.log(error);
          }
        );
        this.router.navigate([`/topic/${this.topic.id}`]);

        // themeForm.reset();
      },
      (error: Error) => {
        // console.log("=========================",error);
        this.router.navigate([`/topic/${this.topic.id}`]);
      }
    );
  }

  getLoggedUser(): void {
    // const userJson = localStorage.getItem('loggedUser');

    const userId = this.sessionStorage.retrieve('userId');
    this.user = new User();
    this.userService.getUserById(userId).subscribe(
      (data) => {
        console.log(data.id);

        this.user = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
