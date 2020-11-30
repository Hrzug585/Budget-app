import { DOCUMENT } from '@angular/common';
import { EventEmitter, Injectable } from '@angular/core';

@Injectable()
export class DarkModeService {
    theme: string = 'lite';
    switchDarkMode = new EventEmitter<string>();


    onUpdate(newMode: string) {
        this.theme = newMode == 'lite' ? 'dark'  : 'lite';
        this.switchDarkMode.emit(this.theme);
        console.log("new update " + this.theme);
    }
}