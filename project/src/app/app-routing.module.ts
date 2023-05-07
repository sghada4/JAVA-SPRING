import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ThemeListComponent } from './theme-list/theme-list.component';
import { CreateThemeComponent } from './create-theme/create-theme.component';
import { UpdateThemeComponent } from './update-theme/update-theme.component';
import { ThemeDetailsComponent } from './theme-details/theme-details.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path: 'themes', component: ThemeListComponent},
  {path: 'themes/new', component: CreateThemeComponent},
  {path: 'themes/edit/:id', component: UpdateThemeComponent},
  {path: 'themes/show/:id', component: ThemeDetailsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
