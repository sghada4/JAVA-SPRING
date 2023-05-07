import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  themes: Theme[];

  constructor(private themeService: ThemeService, private router: Router) {}
  ngOnInit(): void {
    this.getThemes();
  }
  private getThemes() {
    this.themeService.getThemesList().subscribe((data) => {
      this.themes = data;
    });
  }



  showTheme(id: number){
    this.router.navigate(['themes/show', id]);
  }

}
