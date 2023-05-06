import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ThemeListComponent } from './theme-list/theme-list.component';
import { CreateThemeComponent } from './create-theme/create-theme.component';
import { UpdateThemeComponent } from './update-theme/update-theme.component';
import { ThemeDetailsComponent } from './theme-details/theme-details.component';

const routes: Routes = [
  {path: 'themes', component: ThemeListComponent},
  {path: 'themes/new', component: CreateThemeComponent},
  {path: 'themes/edit/:id', component: UpdateThemeComponent},
  {path: 'themes/show/:id', component: ThemeDetailsComponent},
  {path: '', redirectTo: 'themes', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
