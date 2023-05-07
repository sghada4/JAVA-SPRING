import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ThemeListComponent } from './theme-list/theme-list.component';
import { AppRoutingModule } from './app-routing.module';
import { CreateThemeComponent } from './create-theme/create-theme.component';
import { FormsModule } from '@angular/forms';
import { UpdateThemeComponent } from './update-theme/update-theme.component';
import { ThemeDetailsComponent } from './theme-details/theme-details.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    ThemeListComponent,
    CreateThemeComponent,
    UpdateThemeComponent,
    ThemeDetailsComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
