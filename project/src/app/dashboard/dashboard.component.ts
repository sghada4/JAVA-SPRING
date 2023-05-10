import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Router } from '@angular/router';
import { SessionStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  themes: Theme[];
  userId = this.sessionStorage.retrieve('userId');

  constructor(private themeService: ThemeService, private router: Router, private sessionStorage: SessionStorageService) {}
  ngOnInit(): void {
    this.getThemes();
  }
  private getThemes() {
    this.themeService.getThemesList().subscribe((data) => {
      this.themes = data;
    });
  }

  updateTheme(id: number){
    this.router.navigate(['themes/edit', id]);
  }

  deleteTheme(id: number){
    this.themeService.deleteTheme(id).subscribe(data=>{
      this.getThemes();
    }, error=>{
      console.log(error);
      
    })
  }

  logout(){
    this.sessionStorage.clear();
  }
  showTheme(id: number){
    this.router.navigate(['themes/show', id]);
  }
}