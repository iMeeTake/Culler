![title](https://cdn.modrinth.com/data/cached_images/07180a35f0251c713a3a4eea89f2d0a6161eb39e.png)

---------
Client-side mod that improves performance by intelligently hiding (culling) distant entities and block entities that are not visible to the player.
It’s simple, optimized, and works seamlessly with most visual mods and shaders.

# How It Works
The mod skips rendering of objects beyond a configurable distance, saving resources and boosting FPS.
Each object type (mobs, boats, signs, item frames, etc.) can have its own render distance.
Key visual elements remain visible within reasonable ranges to preserve the game’s look.

# Features
- Optimized culling algorithm with minimal performance impact.
- Separate distance settings for different object categories. 
- Full shader and render mod compatibility.


# Known Issues
Signs will not be culled if Enhanced Block Entities is installed with sign culling enabled, because it uses baked models for signs.

---

Requires [oωo](https://modrinth.com/mod/owo-lib) and [TLib](https://modrinth.com/mod/tlib) to work.
