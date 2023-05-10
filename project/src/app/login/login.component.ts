import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Route, Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user';
import { SessionStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  themes: Theme[];
  user = new User();
  message="";

  constructor(private userService: UserService, private themeService: ThemeService, private router: Router,
    private sessionStorage: SessionStorageService) {}
  ngOnInit(): void {
    this.getThemes();
  }
  private getThemes() {
    this.themeService.getThemesList().subscribe((data) => {
      this.themes = data;
    });
  }


  login(){
    this.userService.login(this.user).subscribe(
      data => {
        console.log("response recieved");
        this.sessionStorage.store('userId', data.id);
        if (data.email == "admin@admin.com") {
          this.router.navigate(['/dashboard']);}
          else{
        this.router.navigate(['']);}
    },
      error => {console.log("exception occured");
      this.message="Invalid Credentials!";}
    );

  }

  goToThemeList(){
    this.router.navigate(['']);
  }

  onSubmit(){
    this.login();
  }
  gotoregister(){
    this.router.navigate(['/register']);
  }

}
