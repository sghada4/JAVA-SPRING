import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.css'],
})
export class ThemeListComponent implements OnInit {
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

  showTheme(id: number){
    this.router.navigate(['themes/show', id]);
  }
}
