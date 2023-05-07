import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ActivatedRoute } from '@angular/router';
import { ThemeService } from '../theme.service';

@Component({
  selector: 'app-theme-details',
  templateUrl: './theme-details.component.html',
  styleUrls: ['./theme-details.component.css']
})
export class ThemeDetailsComponent implements OnInit {

  id: number;
  theme: Theme;
  themes: Theme[];

  constructor(private route: ActivatedRoute, private themeService: ThemeService){

  }

  ngOnInit(): void {
    this.getThemes();
    this.id = this.route.snapshot.params['id'];
    this.theme = new Theme();
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

}
