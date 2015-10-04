# ParticleSystem
Really basic particle system implemented in Java a cuple of ears ago, just to have fun and get used to IntelliJ, no architecture was followed.

Consits of:
1.  Particles
- `Emitter` which produces and updates a bunch of particles to be shown in the screen,
- `Particles ` DTO object storing the particle information, life, color, etc, and its own updater which updates its position and life.
- `ParticlePanel` draws the particles.

2.  phisics
A few different updaters to change particle's position and color following some specific phisics laws.
