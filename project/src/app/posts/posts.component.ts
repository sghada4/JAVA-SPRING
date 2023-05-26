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
    createdAt: null
  };
  userId = this.sessionStorage.retrieve('userId');
  topics: Topic[];
  posts: Post[];
  topic: Topic;
  id: number;
  user: User;
  themes: Theme[];
  joinedUsers: User[];

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
    this.getTopics();
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

  private getTopics() {
    this.topicService.getTopicsList().subscribe((data) => {
      this.topics = data;
    });
  }

  logout() {
    this.sessionStorage.clear();
  }

  savePost() {
    this.post.postPostedBy = this.user;
    this.post.postedIn = this.topic;
    this.postService.createPost(this.post).subscribe(
      (response: Post) => {
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
      },
      (error: Error) => {
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

  deletePost(id: number){
    this.postService.deletePost(id).subscribe(data=>{
      // this.getThemes();
      //this.router.navigate([`/topic/${this.topic.id}`]);
      location.reload();
    }, error=>{
      console.log(error);
      this.router.navigate([`/topic/${this.topic.id}`]);
    })
    
  }

  getRemainingJoinedUsers(topicId: number, userId: number){
    this.topicService.getRemainingJoinedUsers(topicId, userId).subscribe(
      (response: User[]) => {
          this.joinedUsers = response;
          // this.test=true;
          // console.log(this.joinedUsers);
          this.router.navigate([``]);
          // location.reload();
      },
      (error: Error) => {
        // this.router.navigate([``]);
      }
    );
  }
}
