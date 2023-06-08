import { createRouter, createWebHistory } from 'vue-router';
import HomePage from "./pages/HomePage.vue";
import PizzaIndex from "./pages/PizzaIndex.vue";
import PizzaCreate from "./pages/PizzaCreate.vue";
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
            name: 'index',
            component: PizzaIndex,
        },
        {
            path: '/pizzas/create',
            name: 'create',
            component: PizzaCreate,
        }
    ]
});
export { router }