import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Route, Router } from '@angular/router';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { SessionStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  user = new User();
  message = '';
  error: any;

  themes: Theme[];

  constructor(
    private userService: UserService,
    private router: Router,
    private themeService: ThemeService,
    private sessionStorage: SessionStorageService
  ) {}
  ngOnInit(): void {
    this.getThemes();
  }
  saveUser() {
    this.userService.createUser(this.user).subscribe(
      (data) => {
        this.sessionStorage.store('userId', data.id);
        if (data.email == 'admin@admin.com') {
          this.router.navigate(['/dashboard']);
        } else {
          this.goToThemeList();
        }
      },
      (error) => {
        // Registration failed
        this.message = error.error;
        console.log(this.message);
      }
    );
  }

  goToThemeList() {
    this.router.navigate(['']);
  }

  onSubmit() {
    this.saveUser();
  }

  private getThemes() {
    this.themeService.getThemesList().subscribe((data) => {
      this.themes = data;
    });
  }
}
