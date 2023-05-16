import { Component, OnInit } from '@angular/core';
import { SessionStorageService } from 'ngx-webstorage';
import { ThemeService } from '../theme.service';
import { Theme } from '../theme';
import { ActivatedRoute, Router } from '@angular/router';
import { TopicService } from '../topic.service';
import { Topic } from '../topic';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-all-topics',
  templateUrl: './all-topics.component.html',
  styleUrls: ['./all-topics.component.css']
})
export class AllTopicsComponent implements OnInit {
  topic: Topic = {
    id: 0,
    topicName: '',
    topicPostedBy: null,
    theme: null,
    joinedUsers:[],
    createdAt: null
  };
  userId = this.sessionStorage.retrieve('userId');
  themes: Theme[];
  topics: Topic[];
  theme: Theme;
  id: number;
  user: User;
  joinedUsers: User[];
  

  constructor(
    private topicService: TopicService,
    private userService: UserService,
    private router: Router,


    private route: ActivatedRoute, private themeService: ThemeService, private sessionStorage: SessionStorageService
  ) {}
  ngOnInit(): void {
    this.getThemes();
    this.getLoggedUser();
    this.id = this.route.snapshot.params['id'];
    this.theme = new Theme();
    this.themeService.getTopicsThemeById(this.id).subscribe(data=>{
      this.topics = data;
      // console.log(data);
      
      
    }, error=>{
      this.router.navigate([`/themes/show/${this.theme.id}`]);
      console.log(error);
      
    })
    this.themeService.getThemeById(this.id).subscribe(data=>{
      this.theme = data;
      
    }, error=>{
      console.log(error);
      
    })
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

  logout(){
    this.sessionStorage.clear();
  }

  saveTopic() {
    this.topic.topicPostedBy = this.user;
    // console.log(this.topic.topicPostedBy);
    
    this.topic.theme = this.theme;
    // console.log(this.user);
    
    // const themeFormData = this.prepareFormData(this.theme)
    this.topicService.createTopic(this.topic).subscribe(
      (response: Topic) => {
        // console.log(response);
        // this.theme.topics.push(response);
        this.topic=response;
        this.themeService.getTopicsThemeById(this.id).subscribe(data=>{
          this.topics = data;
          
        }, error=>{
          this.router.navigate([`/themes/show/${this.theme.id}`]);
          console.log(error);
          
        })
        this.router.navigate([`/themes/show/${this.theme.id}`]);

        // themeForm.reset();
      },
      (error: Error) => {
        // console.log("=========================",error);
        this.router.navigate([`/themes/show/${this.theme.id}`]);
      }
    );
  }

  getLoggedUser(): void {
    // const userJson = localStorage.getItem('loggedUser');
    
    const userId = this.sessionStorage.retrieve('userId');
    this.user = new User();
    this.userService.getUserById(userId).subscribe(
      (data) => {
        // console.log(data.id);
        
        this.user = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  searchByKeyword(searchkeyword :any) {
    // console.log(searchkeyword);
     this.themes = [];
     this.themeService.searchByThemeName(searchkeyword).subscribe((data) => {
      this.themes = data;
    });
  }

  getJoinedUsers(topicId: number, userId: number){

    this.topicService.getJoinedUsers(topicId, userId).subscribe(
      
      (response: User[]) => {
          // this.joinedUsers = response;
          this.topic.joinedUsers = response;
          console.log(this.topic.joinedUsers);
          
        this.router.navigate([`/themes/show/${this.theme.id}`]);
      },
      (error: Error) => {
        this.router.navigate([`/themes/show/${this.theme.id}`]);
      }
    );
  }

  getRemainingJoinedUsers(topicId: number, userId: number){
    this.topicService.getRemainingJoinedUsers(topicId, userId).subscribe(
      (response: User[]) => {
          this.joinedUsers = response;
          // console.log(this.joinedUsers);
        this.router.navigate([`/themes/show/${this.theme.id}`]);
      },
      (error: Error) => {
        this.router.navigate([`/themes/show/${this.theme.id}`]);
      }
    );
  }

  
  userExists(userId: number): boolean {
    return this.joinedUsers.some(user => user.id === userId);
  }

  deleteTopic(id: number){
    this.topicService.deleteTopic(id).subscribe(data=>{
      // this.getThemes();
      // this.router.navigate([`/themes/show/${this.theme.id}`]);
      location.reload();
    }, error=>{
      console.log(error);
      this.router.navigate([`/themes/show/${this.theme.id}`]);
    })
    // this.router.navigate([`/themes/show/${this.theme.id}`]);
  }

  
}
