import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Router } from '@angular/router';
import { SessionStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  themes: Theme[];
  userId = this.sessionStorage.retrieve('userId');

  constructor(private themeService: ThemeService, private router: Router,
    private sessionStorage: SessionStorageService) {}
  ngOnInit(): void {
    this.getThemes();
  }
  private getThemes() {
    this.themeService.getThemesList().subscribe((data) => {
      this.themes = data;
    });
  }


  logout(){
    this.sessionStorage.clear();
  }

  showTheme(id: number){
    this.router.navigate(['themes/show', id]);
  }
}

