import { Component, OnInit } from '@angular/core';
import { ThemeService } from '../theme.service';
import { Theme } from '../theme';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-theme',
  templateUrl: './update-theme.component.html',
  styleUrls: ['./update-theme.component.css']
})
export class UpdateThemeComponent implements OnInit{
  theme: Theme = new Theme();
  id: number; 
  themes: Theme[];
  constructor(private themeService: ThemeService, private route: ActivatedRoute, private router: Router){

  }

  ngOnInit(): void {
    this.getThemes();
    this.id = this.route.snapshot.params['id'];
    this.themeService.getThemeById(this.id).subscribe(data=>{
      this.theme = data;
    }, error =>{
      console.log(error);
      
    });
  }

  onSubmit(){
    this.themeService.updateTheme(this.id, this.theme).subscribe(data =>{
      this.goToThemeList()
    });
  }

  goToThemeList(){
    this.router.navigate(['/themes']);
  }

  private getThemes() {
    this.themeService.getThemesList().subscribe((data) => {
      this.themes = data;
    });
  }
}
