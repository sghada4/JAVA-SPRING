import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
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
