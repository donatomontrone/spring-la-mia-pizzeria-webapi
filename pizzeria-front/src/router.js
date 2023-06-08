import { createRouter, createWebHistory } from 'vue-router';
import HomePage from "./pages/HomePage.vue";
import PizzaIndex from "./pages/PizzaIndex.vue";
const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomePage
        },
        {
            path: '/pizzas',
            name: 'pizzas',
            component: PizzaIndex,
            query: ""
        },
    ]
});
export { router }