task :default => %w{calcugly.js} do
  sh "jsbeautify calcugly.js > jMusic.js"
  sh "rm -f calcugly.js"
end

file "calcugly.js" => %w{jMusic.jison} do
  sh "jison jMusic.jison -o jMusic.js; mv jMusic.js calcugly.js"
end
