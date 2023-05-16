import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Route, Router } from '@angular/router';
import { User } from '../user';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { SessionStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-create-theme',
  templateUrl: './create-theme.component.html',
  styleUrls: ['./create-theme.component.css'],
})
export class CreateThemeComponent implements OnInit {
  theme: Theme = {
    id: 0,
    themeName: '',
    description: '',
    image: '',
    themePostedBy: null,
    topics: [],
    createdAt: null
  };
  userId = this.sessionStorage.retrieve('userId');
  user: User;
  themes: Theme[];

  constructor(
    private themeService: ThemeService,
    private userService: UserService,
    private router: Router,
    private sessionStorage: SessionStorageService
  ) {}
  ngOnInit(): void {
    this.getLoggedUser();
    this.getThemes();

  }
  private getThemes() {
    this.themeService.getThemesList().subscribe((data) => {
      this.themes = data;
    });
  }

  showTheme(id: number) {
    this.router.navigate(['themes/show', id]);
  }

  saveTheme() {
    this.theme.themePostedBy = this.user;
    console.log(this.user);
    
    // const themeFormData = this.prepareFormData(this.theme)
    this.themeService.createTheme(this.theme).subscribe(
      (response: Theme) => {
        // console.log(response);
        this.router.navigate(['/themes']);

        // themeForm.reset();
      },
      (error: Error) => {
        // console.log("=========================",error);
        this.router.navigate(['/themes/new']);
      }
    );
  }

  goToThemeList() {
    this.router.navigate(['/themes']);
  }

  // onSubmit(){
  //   this.saveTheme();
  // }

  getLoggedUser(): void {
    // const userJson = localStorage.getItem('loggedUser');
    
    const userId = this.sessionStorage.retrieve('userId');
    // this.user = new User();
    console.log(this.user);
    
    this.userService.getUserById(userId).subscribe(
      (data) => {
        this.user = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  logout(){
    this.sessionStorage.clear();
  }
}
