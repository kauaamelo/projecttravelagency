function menuShow() {
   let menuMobile = document.querySelector('.mobile-menu');
   if (menuMobile.classList.contains('open')) {
       menuMobile.classList.remove('open');
       document.querySelector('.icon').src = "Image/menu_black_24dp.svg";
   } else {
       menuMobile.classList.add('open');
       document.querySelector('.icon').src = "Image/close_black_24dp.svg";
   }
}