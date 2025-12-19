### Código Markdown para o Guia

# 🔄 Guia de Sincronização de Branchs

Este guia serve para ajudar a equipa a manter as suas branchs pessoais (features) atualizadas com a branch principal de desenvolvimento (`develop`).

Seguir estes passos regularmente evita conflitos gigantes no final do projeto e garante que todos estão a trabalhar com a versão mais recente do código.

---

## 📋 Pré-requisitos

Antes de começar, garante que **não tens alterações pendentes** na tua branch atual.
Execute:
```bash
  git status
```

Se houver arquivos vermelhos ou modificados, faz um commit antes de prosseguir:

```bash
  git add .
  git commit -m "Salvar trabalho antes de sincronizar"
```

---

## 🚀 Passo a Passo

### 1. Mudar para a branch `develop`

Primeiro, saímos da nossa branch pessoal e vamos para a branch principal.

```bash
  git checkout develop
```

### 2. Baixar as últimas atualizações

Agora, vamos buscar o que os outros colegas já enviaram para o GitHub. Isto atualiza a `develop` no teu computador.

```bash
  git pull origin develop
```

### 3. Voltar para a tua branch

Agora que a tua `develop` local está atualizada, volta para a tua branch de trabalho (substitui `nome-da-tua-branch` pelo teu nome, ex: `jonathan`, `Enzo`, `...`).

```bash
  git checkout nome-da-tua-branch
```

### 4. Fundir (Merge) as atualizações

Este é o passo principal. Vamos injetar o código novo da `develop` dentro da tua branch.

```bash
  git merge develop
```

> **Nota:** Se o terminal abrir um editor de texto (Vim ou Nano) a pedir uma mensagem, podes apenas escrever `:q!` ou `Ctrl+X` para aceitar a mensagem padrão.

### 5. Enviar para o GitHub

Agora que a tua branch tem o teu código E o código novo da equipa, envia tudo para o GitHub.

```bash
  git push origin nome-da-tua-branch
```

---

## ⚠️ E se der Conflito?

Se no **Passo 4** aparecer uma mensagem `CONFLICT (content)`, não entres em pânico!

1. O Git vai dizer quais arquivos têm conflito.
2. Abre esses ficheiros no teu editor (VS Code, IntelliJ, etc.).
3. O código conflitante estará marcado assim:
```java
    <<<<<<< HEAD
    Teu código atual
    =======
    Código que veio da develop
    >>>>>>> develop
```


4. Escolhe qual código deve ficar (ou mistura os dois), remove as marcas (`<<<<`, `====`, `>>>>`) e salva o ficheiro.
5. Finaliza o processo:
```bash
  git add .
  git commit -m "Resolvendo conflitos com a develop"
```