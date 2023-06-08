<script>
import HeaderComponent from './components/HeaderComponent.vue';

export default {
  components: {
    HeaderComponent
  },
  methods: {
    search(q) {
      this.$router.push({ path: "/pizzas", query: { name: q } });
    }
  },
}
</script>

<template>
  <HeaderComponent @searchQuery="search" />
  <router-view></router-view>
</template>

<style scoped></style>
