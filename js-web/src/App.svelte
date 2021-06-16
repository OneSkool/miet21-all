<script>
	import { Router, Link, Route } from "svelte-routing";
    import Restaurant from './Restaurant.svelte';
	import { onMount } from 'svelte';


	let resList = []
    let restaurantServiceBaseUrl="http://localhost:8080";

    onMount(async () => {
        const url = restaurantServiceBaseUrl + '/restaurants';
		const res = await fetch(url);
        resList = await res.json();
	});
</script>

<main>
	<h1>Welcome to One Eateries!</h1>

	<h2> List of Restaurants</h2>
	<ul>
		{#each resList as restaurant}
		<p>
			<Restaurant {...restaurant}/>
		</p>
		{/each}
	</ul>

</main>


<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>