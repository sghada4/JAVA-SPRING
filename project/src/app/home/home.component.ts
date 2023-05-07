import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
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

