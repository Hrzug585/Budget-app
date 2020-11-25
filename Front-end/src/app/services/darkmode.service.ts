import { DOCUMENT } from '@angular/common';
import { EventEmitter, Injectable } from '@angular/core';

@Injectable()
export class DarkModeService {
    darkMode: boolean = true;
    switchDarkMode = new EventEmitter<boolean>();


    onUpdate(newMode: boolean) {
        this.darkMode = newMode;
        this.switchDarkMode.emit(newMode);
        console.log("new update " + this.darkMode);
    }
}