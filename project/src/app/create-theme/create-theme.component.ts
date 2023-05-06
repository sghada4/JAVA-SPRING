import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme';
import { ThemeService } from '../theme.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-create-theme',
  templateUrl: './create-theme.component.html',
  styleUrls: ['./create-theme.component.css']
})
export class CreateThemeComponent implements OnInit {
  
  theme: Theme = new Theme();

  constructor(private themeService: ThemeService, private router: Router){}

  ngOnInit(): void {
  }

  saveTheme(){
    this.themeService.createTheme(this.theme).subscribe(data =>{
      console.log(data);
      
      this.goToThemeList();
    }, 
    error => console.log(error));
  }

  goToThemeList(){
    this.router.navigate(['/themes']);
  }

  onSubmit(){
    this.saveTheme();
  }
}
